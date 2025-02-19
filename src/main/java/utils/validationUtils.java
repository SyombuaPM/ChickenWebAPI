package utils;

import java.time.LocalDate;

import exceptions.validationExceptions;

public class validationUtils 
{
    public static void validateId(String id)
    {
        if(id == null || id.isEmpty())
        {
            throw new validationExceptions("chicken", "id cannot be null or empty");
        }
    }
    public static void validateHealthStatus(String healthStatus)
    {
        if(healthStatus == null || healthStatus.isEmpty())
        {
            throw new validationExceptions("chicken", "health status cannot be null or empty");
        }
    }
    public static void validateDateIntroducedToLayingFlock(LocalDate dateIntroducedToLayingFlock)
    {
        if(dateIntroducedToLayingFlock == null)
        {
            throw new validationExceptions("chicken", "date introduced to laying flock cannot be null");
        }
    }
    /*public static void validateDateSold(LocalDate dateSold)
    {
        if(dateSold == null)
        {
            throw new validationExceptions("chicken", "date sold cannot be null");
        }
    }*/
    public static void validateWeight(double weight)
    {
        if(weight <= 0)
        {
            throw new validationExceptions("chicken", "weight cannot be less than or equal to 0");
        }
    }

    public static void validateHatchDate(LocalDate hatchDate)
    {
        if(hatchDate == null)
        {
            throw new validationExceptions("chickGroup", "hatch date cannot be null");
        }
    }
    public static void validateNumberOfChicks(int numberOfChicks)
    {
        if(numberOfChicks <= 0)
        {
            throw new validationExceptions("chickGroup", "number of chicks cannot be less than or equal to 0");
        }
    }
    public static void validateBroodingMethod(String broodingMethod)
    {
        if(broodingMethod == null || broodingMethod.isEmpty())
        {
            throw new validationExceptions("chickGroup", "brooding method cannot be null or empty");
        }
    }
    public static void validateMortalityRate(int mortalityRate)
    {
        if(mortalityRate < 0)
        {
            throw new validationExceptions("chickGroup", "mortality rate cannot be less than 0");
        }
    }
    public static void validateNumberOfChicksSold(int numberOfChicksSold)
    {
        if(numberOfChicksSold < 0)
        {
            throw new validationExceptions("chickGroup", "number of chicks sold cannot be less than 0");
        }
    }
    public static void validateGroupID(String groupId)
    {
        if(groupId == null || groupId.isEmpty())
        {
            throw new validationExceptions("chickGroup", "group id cannot be null or empty");
        }
    }

    

}
