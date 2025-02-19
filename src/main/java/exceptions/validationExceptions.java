package exceptions;

public class validationExceptions extends RuntimeException
{
    //instance variable to store name of the entity related to validation exception
    private String entityName;

    //constructor
    public validationExceptions(String entityName, String message)
    {
        super(message);
        this.entityName = entityName;
    }

    //getter for entityName it allows other classes to access the entityName
    public String getEntityName()
    {
        return entityName;
    }

}
