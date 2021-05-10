package ic.snakeai.Services;

import java.util.ArrayList;
import java.util.List;

import ic.snakeai.Exceptions.EmptyFieldException;
import ic.snakeai.Exceptions.IncorrectLoginData;
import ic.snakeai.Models.UserModel;
  
/* ******************************************************************
 *
 *   User Service manages the users
 *
 * *******************************************************************/
public class UserService {

    /*List of users*/
    private static List<UserModel> users;
    private static UserModel user;

    static {
        users = new ArrayList<UserModel>();
    }


    /*********************************************************************************************
     *
     *
     * This method loads the users from the corresponding file.
     *
     *
     *
     * *********************************************************************************************/
    public static void loadUsersFromFile() {
        /*Path for users: users_PATH*/
        String pathJSONFile = "users.json";
        //private static final Path users_PATH = new Path("users.json");

       
       // JSONObject jsonObject = new JSONObject(pathJSONFile);
/*
        if (!Files.exists(users_PATH)) {
            FileUtils.copyURLToFile(Objects.requireNonNull(UserService.class.getClassLoader().getResource("users.json")), users_PATH.toFile());
        }

        ObjectMapper objectMapperusers = new ObjectMapper();

        users = objectMapperusers.readValue(users_PATH.toFile(), new TypeReference<List<user>>() {
        }); */
    }


    /* *********************************************
     *
     *   This method adds the users.
     *
     * **********************************************/
    public static void addUser(String username, String password, Integer maxScore) throws Exception {

        checkEmptyField(username, password);
        checkUsernameAlreadyExist(username);
        users.add(new UserModel(username, encodePassword(username, password), maxScore));
        persistUsers();
    }

    /****************************************
     *
     *
     *  This method persists the users.
     *
     * ****************************************/
    private static void persistUsers() {
/*
        try {

            Object ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(users_PATH.toFile(), users);

        } catch (IOException e) {
            throw new CouldNotWriteUsersException();
        }*/
    }

    /*****************************************************
     *
     *
     *  This method checks if an username already exists.
     *
     *
     * *****************************************************/
    public static void checkUsernameAlreadyExist(String username) throws EmptyFieldException, IncorrectLoginData {

            /*users' usernames are checked.*/
            for (UserModel user : users)
                if (username.equals(user.getUsername())) {
                    throw new IncorrectLoginData();
                }
    }


    /**********************************************
     *
     *  This method checks if an attribute is empty.
     *
     * **********************************************/
    public static void checkEmptyField(String username, String password) throws EmptyFieldException {

        if(username.equals("") || password.equals(""))
            throw new EmptyFieldException();
    }


    /********************************************************
     *
     *  This method checks if the login credentials are correct.
     *
     * ********************************************************/
    public static void checkLoginCredentials(String username, String password) throws IncorrectLoginData {
        int sw=0;

            for (UserModel user : users) {
                if (username.equals(user.getUsername())) {
                    if(password.equals(user.getPassword())) {
                       // ListUsersController.setActiveuser(user);
                       // part = user;
                    }
                    sw=1;
                    if (!password.equals(user.getPassword()))
                        throw new IncorrectLoginData();
                }
            }
            if(sw==0) //n-am gassit user ul
                throw new IncorrectLoginData();
    }


    /********************************************************
     *
     *  This method encodes the password
     *
     * ********************************************************/
    private static java.lang.String encodePassword(java.lang.String salt, java.lang.String password) {
/*
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
*/
        /*This is the way a password should be encoded when checking the credentials*/
     /*   return new java.lang.String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", ""); /*to be able to save in JSON format*/
        return "";
    }
  /*
    public static void sentParticiapnt(String user, Application application) {
        for(user user1:users) {
            String name=user1.getFirstName()+" "+user1.getLastName();
            if(name.equals(user)) {
                System.out.println("intra in if");
                user1.getApplications().add(application);
            }
        }
        persistusers();
    }

    public static List<user> getusers(){
        return users;
    }
    }

    public static void injectppc(userPageController userPageController) {
        ppc=userPageController;
    }*/
}