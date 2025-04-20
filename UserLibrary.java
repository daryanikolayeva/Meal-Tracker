
//--------------------------------------------------------------------
// Class: UserLibrary
// Author: Nikolayeva Darya
// Remarks: It is a library of Users
//SubClass of GenericLibrary
//------------------------------------------------------------------
public class UserLibrary extends GenericLibrary {

    // --------------------------------------------------------------------------------
    // getUser
    // Purpose:returns User of type user by calling superclasses method super.get()
    // ---------------------------------------------------------------------------------
    public User getUser(String username) {
        return (User) super.get(username);
    }
}
