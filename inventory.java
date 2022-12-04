package hw8;


public class inventory extends LibraryWindow{
	//Utilizing a binary search tree for our textbooks
	public BookNode root;

	//constructor
	public inventory() {
		root = null;
	}

	public void addTextbook(textbook book) {
		//creating a temporary node
		BookNode temp = new BookNode(book);

		//Checking if it's empty
		if(root == null)
			root = temp;

		/*
		 *if it's not empty then we have to insert it which will be
		 *a separate function
		 */

		else {
			insert(root, temp);
		}
	}

	private void insert(BookNode myRoot, BookNode temp) {
		while(true) {
			if(temp.getTextbook().compareTo(myRoot.getTextbook()) == 0) {
				myRoot.getTextbook().setQuantity(myRoot.getTextbook().getQuantity() + temp.getTextbook().getQuantity());
			}
			if(temp.getTextbook().compareTo(myRoot.getTextbook()) <= -1) {
				if(myRoot.left != null)
					myRoot = myRoot.left;
				else {
					myRoot.left = temp;
					break;
				}	
			}

			else {
				if(myRoot.right != null)
					myRoot = myRoot.right;
				else {
					myRoot.right = temp;
					break;
				}
			}	
		}
	}

	public void inOrder() {
		inOrderRecursive(root);
	}
	public void removeBook(int val) {
		removeTextbookRec(root, val);
	}
	public void findBook(int val) {
		findTextbook(root, val);
	}
	public void resetTree() {
		reset();
	}
	@SuppressWarnings("unused")
	private void inOrderRecursive(BookNode myRoot) {
		if(myRoot != null) {
			inOrderRecursive(myRoot.left);
			System.out.println(myRoot.getTextbook());
			inOrderRecursive(myRoot.right);
		}
	} 

	private void removeTextbookRec(BookNode myRoot, int val) {
		/*
		 * Creating a parent node so that when we remove a value,
		 * we reattach the previous node we were at to the next node
		 */
		BookNode parent = root;
		while(true) {
			if(myRoot == null)
				break;

			/*
			 * If the SKU value we're looking for is found
			 * we'll be removing the value from the BST
			 */
			if(myRoot.getTextbook().getSKU() == val) {
				if(myRoot.left != null) {
					if(myRoot != root) {
						if(parent.left == myRoot)
							parent.left = findRepl(myRoot.left, myRoot);
						if(parent.right == myRoot)
							parent.right = findRepl(myRoot.left, myRoot);
					}
				}
				else if(myRoot.right != null) {
					if(myRoot != root) {
						if(parent.left == myRoot)
							parent.left = myRoot.right;
						if(parent.right == myRoot)
							parent.right = myRoot.right;
					}
				}
				else {
					if(parent.left == myRoot)
						parent.left = null;
					if(parent.right == myRoot)
						parent.right = null;
				}
			}
			/*
			 * If the SKU value is too large, we'll run down the
			 * binary search tree to the righ tnow
			 */
			if(myRoot.getTextbook().getSKU() < val) {
				if (myRoot.right != null) {
					parent = myRoot;
					myRoot = myRoot.right;
				}
				else {
					outputText.setText("The textbook does not exist");
				}
				/*
				 * If it's too small then we'll run down to the left
				 */
			} else {
				if (myRoot.left != null) {
					parent = myRoot;
					myRoot = myRoot.left;
				}
				else {
					outputText.setText("The textbook does not exist");
				}
			}
		}
	}

	/*
	 * Function to find the highest value
	 */
	private BookNode findRepl(BookNode curr, BookNode parent) {
		while(true) {
			if(curr.right != null) {
				parent = curr;
				curr = curr.right;
			}
			else {
				/*
				 * removing the value from the binary search tree so
				 * we can shift it up to the removed textbook
				 */
				if(curr.left != null) {
					parent.right = curr.left;
					break;
				}
				else {
					parent.right = null;
					break;
				}
			}
		}
		return curr;
	}
	private void findTextbook(BookNode curr, int sku) {
		while(true) {
			if(curr.getTextbook().getSKU() == sku) {
				outputText.setText(curr.toString());
				break;
			}
			else {
				if(curr.getTextbook().getSKU() < sku) {
					if (curr.right != null) {
						curr = curr.right;
					}
					else {
						outputText.setText("The textbook does not exist");
					}
					/*
					 * If it's too small then we'll run down to the left
					 */
				} else {
					if (curr.left != null) {
						curr = curr.left;
					}
					else {
						outputText.setText("The textbook does not exist");
					}
				}
			}
		}
	}
	private void reset() {
		root = null;
	}
}
