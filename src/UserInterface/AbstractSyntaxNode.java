package UserInterface;

import org.jetbrains.annotations.NotNull;

public class AbstractSyntaxNode {
	private String data;
	private AbstractSyntaxNode parent;
	private AbstractSyntaxNode left;
	private AbstractSyntaxNode right;
	private boolean isLeaf;
	private boolean isUnary;

	public AbstractSyntaxNode(String data, boolean isLeaf, boolean isUnary) {
		this.data = data;
		this.isLeaf = isLeaf;
		this.isUnary = isUnary;
		left = null;
		right = null;
	}

	public AbstractSyntaxNode (String data, AbstractSyntaxNode left){
		this.data = data;
		this.isLeaf = false;
		this.isUnary = true;
		this.left = left;
		this.right = null;
	}
	
	public AbstractSyntaxNode (String data, AbstractSyntaxNode left, AbstractSyntaxNode right){
		this.data = data;
		this.isLeaf = false;
		this.isUnary = false;
		this.left = left;
		this.right = right;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public boolean isUnary() {
		return isUnary;
	}

	public boolean isNumber() {
		try {
			Integer.parseInt(data);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isVariable() {
		char[] chars = data.toCharArray();
		if (chars.length > 1){
			return false;
		}
		return Character.isAlphabetic(chars[0]);
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public AbstractSyntaxNode getLeft() {
		return left;
	}

	public AbstractSyntaxNode getRight() {
		return right;
	}

	public void setLeft(AbstractSyntaxNode left) {
		this.left = left;
	}

	public void setRight(AbstractSyntaxNode right) {
		this.right = right;
	}

	public boolean addNode(AbstractSyntaxNode currentNode, AbstractSyntaxNode newNode) {
		if (data.equals("")) {
			data = newNode.getData();
			isLeaf = newNode.isLeaf();
			isUnary = newNode.isUnary();
			return true;
		}
		if (currentNode.getLeft() == null && !currentNode.isLeaf()) {
			currentNode.setLeft(newNode);
			return true;
		}
		if (!currentNode.isLeaf()) {
			if (addNode(currentNode.getLeft(), newNode)) {
				return true;
			}
		}
		if (currentNode.getRight() == null && !(currentNode.isLeaf() || currentNode.isUnary())) {
			currentNode.setRight(newNode);
			return true;
		}
		if (!(currentNode.isLeaf() || currentNode.isUnary())) {
			return addNode(currentNode.getRight(), newNode);
		} else {
			return false;
		}
	}

	public String getExpression(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder = generateExpression(stringBuilder);
		return stringBuilder.toString();
	}

	private StringBuilder generateExpression(StringBuilder sb){
		if (this.data.equals("()")) {
			sb.append("(");
			sb = left.generateExpression(sb);
			sb.append(")");
		} else if (this.data.equals("sin")
				|| this.data.equals("cos")
				|| this.data.equals("tan")
				|| this.data.equals("cot")
				|| this.data.equals("sec")
				|| this.data.equals("csc")) {
			sb.append(data);
			sb.append("(");
			sb = left.generateExpression(sb);
			sb.append(")");
		} else {
			if (this.left != null) sb = left.generateExpression(sb);
			sb.append(data);
			if (this.right != null) sb = right.generateExpression(sb);
		}
		return sb;
	}

	public void printExpression() {
		if (this.data.equals("()")) {
			System.out.print("(");
			left.printExpression();
			System.out.print(")");
		} else if (this.data.equals("sin")
				|| this.data.equals("cos")
				|| this.data.equals("tan")
				|| this.data.equals("cot")
				|| this.data.equals("sec")
				|| this.data.equals("csc")) {
			System.out.print(data + "(");
			left.printExpression();
			System.out.print(")");
		} else {
			if (this.left != null) left.printExpression();
			System.out.print(data);
			if (this.right != null) right.printExpression();
		}
	}

	public static boolean treeEquality(AbstractSyntaxNode a, AbstractSyntaxNode b) {
		if (a == null && b == null) {
			return true;
		}
		if (a != null && b != null)
			return a.getData().equals(b.getData())
					&& AbstractSyntaxNode.treeEquality(a.getLeft(), b.getLeft())
					&& AbstractSyntaxNode.treeEquality(a.getRight(), b.getRight());
		return false;
	}

	@SuppressWarnings("Duplicates")
	public void simplify() {
		if (!isLeaf) {
			if (left != null) {
				left.simplify();
			}
			if (right != null) {
				right.simplify();
			}
			try {
				switch (data) {
					case "*":
						multiplicationRules();
						break;
					case "/":
						divisionRules();
						break;
					case "+":
						additionRules();
						break;
					case "-":
						subtractionRules();
						break;
				}
				//if it's a trig function
				if (isUnary && !data.equals("()")){
					trigRules();
				}
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	private void additionRules() {
		//check redundancy rules first and if applied ignore other rules
		if (addSubRedundancy()) {
			//evaluation
			if (right.isNumber() && left.isNumber()) {
				int newNo = Integer.parseInt(left.getData()) + Integer.parseInt(right.getData());
				this.set(Integer.toString(newNo), false, true, null, null);
			}
			//top down evaluation
			else if (right.isNumber() && (left.getData().equals("+") || left.getData().equals("-"))) {
				int newNo;
				if (left.getData().equals("+")) {
					newNo = Integer.parseInt(left.getRight().getData()) + Integer.parseInt(right.getData());
				} else {
					newNo = Integer.parseInt(right.getData()) - Integer.parseInt(left.getRight().getData());
					if (newNo < 0) {
						data = "-";
						newNo = Math.abs(newNo);
					}
				}
				if (newNo == 0) {
					pullNode(left.getLeft());
				} else {
					right.setData(Integer.toString(newNo));
					left = left.getLeft();
				}
			}
			//variable addition
			if (left.getData().equals("*") && left.getData().equals("*")){
				if (left.getRight().getData().equals(right.getRight().getData())){
					//simple case, two coefficients are numbers
					if (left.getLeft().isNumber() && right.getLeft().isNumber()){
						int newCoeff = Integer.parseInt(left.getLeft().getData())
								+ Integer.parseInt(right.getLeft().getData());
						this.set("*", false, false,
								new AbstractSyntaxNode(Integer.toString(newCoeff), true, false),
								new AbstractSyntaxNode(right.getRight().getData(), true, false));
					}
					//coefficients are not numbers
					else {
						AbstractSyntaxNode var = right.getRight();
						AbstractSyntaxNode leftCoeff = left.getLeft();
						AbstractSyntaxNode rightCoeff = right.getLeft();
						AbstractSyntaxNode newCoeff = new AbstractSyntaxNode("+", leftCoeff, rightCoeff);
						this.set("*", false, false, new AbstractSyntaxNode("()", newCoeff), var);
					}
				}
			}
		}
	}

	private void subtractionRules() {
		//check redundancy rules first and if applied ignore other rules
		if (addSubRedundancy()) {
			//evaluation
			if (right.isNumber() && left.isNumber()) {
				int newNo = Integer.parseInt(left.getData()) - Integer.parseInt(right.getData());
				data = Integer.toString(newNo);
				left = null;
				right = null;
				isLeaf = true;
			}
			//top down evaluation
			else if (right.isNumber() && (left.getData().equals("+") || left.getData().equals("-"))) {
				int newNo;
				if (left.getData().equals("+")) {
					newNo = Integer.parseInt(left.getRight().getData()) - Integer.parseInt(right.getData());
					if (newNo < 0) {
						data = "-";
						newNo = Math.abs(newNo);
					}
				} else {
					newNo = Integer.parseInt(left.getRight().getData()) + Integer.parseInt(right.getData());
				}
				if (newNo == 0) {
					pullNode(left.getLeft());
				} else {
					right.setData(Integer.toString(newNo));
					left = left.getLeft();
				}
			}
		}
	}

	private void multiplicationRules(){
		//redundancy rules
		if (left.getData().equals("1")) {
			pullNode(right);
		}
		else if (right.getData().equals("1")) {
			pullNode(left);
		}
		//evaluation
		else if (left.isNumber() && right.isNumber()) {
			int newNo = Integer.parseInt(left.getData()) * Integer.parseInt(right.getData());
			this.set(Integer.toString(newNo), false, true, null, null);
		}
		//Variable reorder
		else if (left.isVariable() && right.isNumber()){
			swapLeftRight();
		}
	}

	private void divisionRules(){
		//redundancy rule
		if (right.data.equals("1")) {
			pullNode(left);
		}
		//evaluation
		else if (left.isNumber() && right.isNumber()) {
			//only simplify numbers that do not result in floating points
			//Otherwise leave as "fraction"
			if (Integer.parseInt(left.getData()) % Integer.parseInt(right.getData()) == 0) {
				int newNo = Integer.parseInt(left.getData()) / Integer.parseInt(right.getData());
				this.set(Integer.toString(newNo), false, true, null, null);
			}
		}
		//Tan and cot rules rule
		else if (left.getData().equals("sin")
				&& right.getData().equals("cos")
				&& treeEquality(left.getLeft(), right.getLeft())) {
			this.set("tan", true, false, left.getLeft(), null);
		} else if (left.getData().equals("cos")
				&& right.getData().equals("sin")
				&& treeEquality(left.getLeft(), right.getLeft())) {
			this.set("cot", true, false, left.getLeft(), null);
		}
	}

	private void trigRules(){
		if (left.isNumber()) {
			int operand = Integer.parseInt(left.getData());
			//redundant cases of trig functions
			switch (data) {
				case "sin":
					if (operand % 270 == 0) {
						this.set("-1", false, true, null, null);
					} else if ((operand % 180 == 0)) {
						this.set("0", false, true, null, null);
					} else if (operand % 90 == 0){
						this.set("1", false, true, null, null);
					}
					break;
				case "cos":
					if (operand % 360 == 0){
						this.set("1", false, true, null, null);
					} else if (operand % 180 == 0) {
						this.set("-1", false, true, null, null);
					} else if (operand % 90 == 0){
						this.set("0", false, true, null, null);
					}
					break;
				case "tan":
					if (operand % 180 == 0){
						this.set("0", false, true, null, null);
					}
					break;
				case "csc":
					if (operand % 270 == 0){
						this.set("-1", false, true, null, null);
					} else if (operand % 90 == 0){
						this.set("1", false, true, null, null);
					}
					break;
				case "sec":
					if (operand % 360 == 0){
						this.set("1", false, true, null, null);
					} else if (operand % 180 == 0){
						this.set("-1", false, true, null, null);
					}
					break;
				case "cot":
					if ((operand % 90 == 0) && (operand % 180 != 0)){
						this.set("0", false, true, null, null);
					}
			}
		}
	}

	private boolean addSubRedundancy() {
		if (left.getData().equals("0")) {
			pullNode(right);
			return false;
		}
		if (right.getData().equals("0")) {
			pullNode(left);
			return false;
		}
		return true;
	}

	private void pullNode(@NotNull AbstractSyntaxNode node){
		data = node.getData();
		isLeaf = node.isLeaf();
		isUnary = node.isUnary();
		left = node.getLeft();
		right = node.getRight();
	}

	private void swapLeftRight(){
		AbstractSyntaxNode temp = left;
		left = right;
		right = temp;
	}

	private void set(String data, boolean isUnary, boolean isLeaf, AbstractSyntaxNode left, AbstractSyntaxNode right){
		this.data = data;
		this.isUnary = isUnary;
		this.isLeaf = isLeaf;
		this.left = left;
		this.right = right;
	}
}
