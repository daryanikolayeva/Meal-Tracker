//--------------------------------------------------------------------
// Class: ListItem
// Author: Nikolayeva Darya
// Remarks:Superclass of whole hierarchy
//------------------------------------------------------------------
public abstract class ListItem {

    // ------------------------------------------------------
    // getDescription
    // PURPOSE:polymorphic method. That will return appropriate String description
    // based on its dynamic type
    // ------------------------------------------------------

    public abstract String getDescription();
}