package hw8;

class BookNode {
    public textbook n;
    public BookNode left;
    public BookNode right;
 
    /* BST Node*/
    public BookNode (textbook f) {
    	this.n = f;
    	left = null;
    	right = null;
    }
    
    public textbook getTextbook() {
    	return n;
    }
}