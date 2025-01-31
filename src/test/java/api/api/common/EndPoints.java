package api.api.common;

import javax.swing.plaf.PanelUI;

public class EndPoints {

   //bookstore.demoqa.com

//    Account endpoints
   public static final String ACCOUNT_USER_POST = "/Account/V1/User";
    public static final String ACCOUNT_AUTHORIZED_ACCOUNT = "/Account/V1/Authorized";
    public static final String ACCOUNT_GENERATE_TOKEN = "/Account/v1/GenerateToken";
    public static final String ACCOUNT_DELETE_USER = "/Account/V1/User/";
    public static final String ACCOUNT_GET_USER_Without_Token = "/Account/V1/User/{UUID}";
    public static final String ACCOUNT_GET_USER = "/Account/V1/User/";

 //    BookStore endpoints
    public static final String GET_ALL_BOOKS ="/BookStore/v1/Books";
    public static final String GET_SPECIFIC_BOOK ="/BookStore/v1/Book?ISBN=";
    public static final String POST_BOOKS ="/BookStore/v1/Books";
    public static final String PUT_BOOKS ="/BookStore/v1/Books/";
    public static final String DELETE_BOOKS ="/BookStore/v1/Book";
    public static final String DELETE_BOOKS_USERID ="/BookStore/v1/Books?UserId=";

   //http://localhost:3000/api/students(visual studio)

    public static final String MY_NEXT_APP_GET = "/api/students";
    public static final String MY_NEXT_APP_GET_SPECIFIC_STUDENT = "/api/students/";
    public static final String MY_NEXT_APP_POST_STUDENTS = "/api/students";







}
