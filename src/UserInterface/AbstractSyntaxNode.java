package UserInterface;

public class AbstractSyntaxNode {
	private String data;
	private AbstractSyntaxNode parent;
	private AbstractSyntaxNode left;
	private AbstractSyntaxNode right;
	private boolean isLeaf;
	private boolean isTrig;

	public AbstractSyntaxNode(String data, boolean isLeaf, boolean isTrig) {
		this.data = data;
		this.isLeaf = isLeaf;
		this.isTrig = isTrig;
		left = null;
		right = null;
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public boolean isTrig() {
		return isTrig;
	}

	public boolean isNumber() {
		try {
			Integer.parseInt(data);
			return true;
		} catch (Exception e) {
			return false;
		}
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
			isTrig = newNode.isTrig();
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
		if (currentNode.getRight() == null && !(currentNode.isLeaf() || currentNode.isTrig())) {
			currentNode.setRight(newNode);
			return true;
		}
		if (!(currentNode.isLeaf() || currentNode.isTrig())) {
			return addNode(currentNode.getRight(), newNode);
		} else {
			return false;
		}
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
				data = Integer.toString(newNo);
				left = null;
				right = null;
				isLeaf = true;
			} else if (right.isNumber() && (left.getData().equals("+") || left.getData().equals("-"))) {
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
					data = left.getLeft().getData();
					isLeaf = left.getLeft().isLeaf();
					isTrig = left.getLeft().isTrig();
					right = left.getLeft().getRight();
					left = left.getLeft().getLeft();
				} else {
					right.setData(Integer.toString(newNo));
					left = left.getLeft();
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
			} else if (right.isNumber() && (left.getData().equals("+") || left.getData().equals("-"))) {
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
					pullNode(left);
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
			data = Integer.toString(newNo);
			left = null;
			right = null;
			isLeaf = true;
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
				data = Integer.toString(newNo);
				left = null;
				right = null;
				isLeaf = true;
			}
		}
		//Tan and cot rules rule
		else if (left.getData().equals("sin")
				&& right.getData().equals("cos")
				&& treeEquality(left.getLeft(), right.getLeft())) {
			data = "tan";
			left = left.getLeft();
			right = null;
			isTrig = true;
		} else if (left.getData().equals("cos")
				&& right.getData().equals("sin")
				&& treeEquality(left.getLeft(), right.getLeft())) {
			data = "cot";
			left = left.getLeft();
			right = null;
			isTrig = true;
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

	private void pullNode(AbstractSyntaxNode node){
		data = node.getData();
		isLeaf = node.isLeaf();
		isTrig = node.isTrig();
		left = node.getLeft();
		right = node.getRight();
	}
}
