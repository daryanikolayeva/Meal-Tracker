//--------------------------------------------------------------------
// Class: GenericLibrary
// Author: Nikolayeva Darya
// Remarks: It is a generic library for list items
//Superclass of foodLibrary and UserLibrary
//------------------------------------------------------------------
public class GenericLibrary extends ListItem {
    protected Node top;
    private String description;

    // --------------------------------------------------------------------
    // Class: Node
    // Author: Nikolayeva Darya, 7974499
    // Protected class Node for usage inside GenericList class and its
    // subclasses(UserLibrary and FoodLibrary)
    // ------------------------------------------------------------------
    protected class Node {
        ListItem item;
        Node link;

        public Node(ListItem item, Node link) {
            this.item = item;
            this.link = link;
        }
    }

    // --------------------------------------------------------------------------------
    // GenericLibrary()
    // Purpose:defualt constructor
    // ---------------------------------------------------------------------------------
    public GenericLibrary() {
        top = null;
        description = null;
    }

    // --------------------------------------------------------------------------------
    // getDescription()
    // Purpose: returns description
    // ---------------------------------------------------------------------------------
    public String getDescription() {
        return description;
    }

    // --------------------------------------------------------------------------------
    // add()
    // Purpose: add Item of type ListItem to the list
    // Input parameters:ListItem item
    // Remark: if item already exist, will stop and not add it
    // Will work like this for its subClass UserLibrary, since we can't have
    // duplicates of users
    // But in FoodLibrary we need ability to update food, so it is overriden there
    // ---------------------------------------------------------------------------------
    public void add(ListItem item) {
        if (isFound(item.getDescription())) {
            System.out.println("Item already exists.");
            return;
        }
        top = new Node(item, top);
    }

    // --------------------------------------------------------------------------------
    // isFound()
    // Purpose: check if given key is contained in list
    // Input parameters: String key(what we look for in list)
    // Return parameter: boolean ( found or not)
    // ---------------------------------------------------------------------------------
    public boolean isFound(String key) {
        Node current = top;
        while (current != null) {
            if (current.item.getDescription().equals(key)) {
                return true;
            }
            current = current.link;
        }
        return false;
    }

    // --------------------------------------------------------------------------------
    // get()
    // Purpose: return ListItem of given key
    // Input parameters: String key ( ListItem with that given key we want to get)
    // Output: ListItem ( item we were looking for)
    // or null, if ListItem with given key is not found
    // ---------------------------------------------------------------------------------
    public ListItem get(String key) {
        Node current = top;
        while (current != null) {
            if (current.item.getDescription().equals(key)) {
                return current.item;
            }
            current = current.link;
        }
        return null;
    }

    // --------------------------------------------------------------------------------
    // getTop()
    // Purpose:return top Node of list
    // Return parameter: Node
    // ---------------------------------------------------------------------------------
    public Node getTop() {
        return top;
    }
}
