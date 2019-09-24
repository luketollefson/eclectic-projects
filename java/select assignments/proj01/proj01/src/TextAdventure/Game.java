package TextAdventure;

import java.util.Scanner;

/**
 *
 * @author Alex
 */
public class Game 
{
    private World   world;
    private Player  player;
    private Room    currentRoom; 
    
    private String  startText = "Welcome to Text Adventure!";
    private String  victoryText = "You have reached the end of your adventure."; 
    
    private Scanner scan; 
    
    public Game(World world, Player player)
    {
        this.world  = world;
        this.player = player; 
        
        currentRoom = world.getStartingRoom(); 
        
        scan        = new Scanner(System.in); 
    }
    
    public void setStartText(String text)
    {
        startText = text; 
    }
    
    public void setVictoryText(String text)
    {
        victoryText = text; 
    }
    
    public void start()
    {
        this.displayStartText();
        
        while(currentRoom != world.getEndingRoom())
        {
            // Print out a description of the current room
            this.describeRoom();
            
            // List exits
            this.describeExits();
            
            // List items
            this.describeItem();
            
            // List creatures
            this.describeCreatures();
            
            // Read in and process user commands until we change rooms
            processInputUntilRoomChange();
        }
        
        System.out.println(currentRoom.getDescription());
        
        this.displayVictoryText();
    }
    
    private void displayStartText()
    {
        System.out.println(startText);
    }
    
    private void displayVictoryText()
    {
        System.out.println(victoryText);
    }
    
    private void describeRoom()
    {
        System.out.println(currentRoom.getDescription());
    }
    
    private void describeExits()
    {
        System.out.println("Visible Exits:");
            
        // Check if each Exit exists before attempting to display it
        if(currentRoom.getExit1() != null)
        {
            System.out.println(" " + currentRoom.getExit1().getName());
        }

        if(currentRoom.getExit2() != null)
        {
            System.out.println(" " + currentRoom.getExit2().getName());
        }

        if(currentRoom.getExit3() != null)
        {
            System.out.println(" " + currentRoom.getExit3().getName());
        }

        if(currentRoom.getExit4() != null)
        {
            System.out.println(" " + currentRoom.getExit4().getName());
        }
    }
    
    private void describeItem()
    {
        System.out.println("Visible Items:");
        
        // Check if there's an Item in the current room. 
        if(currentRoom.getItem() != null)
        {
            System.out.println(" " + currentRoom.getItem().getName());
        }
        else
        {
            System.out.println(" None");
        }
    }
    
    private void describeCreatures()
    {
        System.out.println("Creatures Present:");
        System.out.println(" You");

        // Check if there's a Creature in the current room.
        if(currentRoom.getCreature() != null)
        {
            System.out.println(" " + currentRoom.getCreature().getName());
        }
    }
    
    private void displayCommands()
    {
        System.out.println("Commands:");
        System.out.println("look - examine a Room, Exit, Creature, or Item.");
        System.out.println("get - acquire an Item.");
        System.out.println("use - use an Item.");
        System.out.println("go - move to a different Room through an Exit.");
        System.out.println("inventory - list each Item held by the player.");
    }
    
    private void displayDescription(String thingToDescribe)
    {
        if (thingToDescribe.equalsIgnoreCase("look") || thingToDescribe.equals(""))
        {
            this.describeRoom();
            this.describeExits();
            this.describeItem();
            this.describeCreatures();
        }
        
        // Check if they tried to look at an exit
        
        else if (currentRoom.getExit1() != null && thingToDescribe.equalsIgnoreCase(currentRoom.getExit1().getName()))
        {
            System.out.println(currentRoom.getExit1().getDescription());
        }
        else if (currentRoom.getExit2() != null && thingToDescribe.equalsIgnoreCase(currentRoom.getExit2().getName()))
        {
            System.out.println(currentRoom.getExit2().getDescription());
        }
        else if (currentRoom.getExit3() != null && thingToDescribe.equalsIgnoreCase(currentRoom.getExit3().getName()))
        {
            System.out.println(currentRoom.getExit3().getDescription());
        }
        else if (currentRoom.getExit4() != null && thingToDescribe.equalsIgnoreCase(currentRoom.getExit4().getName()))
        {
            System.out.println(currentRoom.getExit4().getDescription());
        }
        else if (currentRoom.getSecretExit() != null && thingToDescribe.equalsIgnoreCase(currentRoom.getSecretExit().getName()))
        {
            System.out.println(currentRoom.getSecretExit().getDescription());
        }
        
        // Check if they tried to look at an item
        
        else if (currentRoom.getItem() != null && thingToDescribe.equalsIgnoreCase(currentRoom.getItem().getName()))
        {
            System.out.println(currentRoom.getItem().getDescription());
        }
        
        // Check if they tried to look at a creature
        
        else if (currentRoom.getCreature() != null && thingToDescribe.equalsIgnoreCase(currentRoom.getCreature().getName()))
        {
            System.out.println(currentRoom.getCreature().getDescription());
        }
        
        // Check if they tried to look at themselves
        
        else if(thingToDescribe.equalsIgnoreCase("me") || thingToDescribe.equalsIgnoreCase("you"))
        {
            System.out.println(player.getDescription());
            System.out.println("To see what items are currently in your possession, type \"inventory\"");
        }
        
        // Check if they tried to look at something in their inventory. 
        
        else if(player.getItemFromInventory(thingToDescribe) != null)
        {
            System.out.println(player.getItemFromInventory(thingToDescribe).getDescription());
        }
        
        // They have entered something that isn't valid
        
        else
        {
            
            
            System.out.println("You can't seem to find a " + thingToDescribe);
        }      
    }
    
    private void acquireItem(String thingToAcquire)
    {
        if(thingToAcquire.equalsIgnoreCase("get") || thingToAcquire.equals(""))
        {
            System.out.println("Get what?");
            return; 
        }
        
        // Check if they tried to get the Item in the current Room
        if (currentRoom.getItem() != null && thingToAcquire.equalsIgnoreCase(currentRoom.getItem().getName()))
        {
            // Add the Item to the inventory of the Player and remove it from the Room
            player.addItemToInventory(currentRoom.getItem());
            currentRoom.setItem(null);
            System.out.println("You pick up the " + thingToAcquire + " and add it to your inventory.");
        }
        
        // Check if they tried to get themselves or a creature 
        else if (thingToAcquire.equalsIgnoreCase("you") || thingToAcquire.equalsIgnoreCase("me"))
        {
            System.out.println("You can't get \"you\". No one could ever get you. Especially your parents, which is probably why you went on this adventure in the first place.");
        }
        else if (currentRoom.getCreature() != null && thingToAcquire.equalsIgnoreCase(currentRoom.getCreature().getName()))
        {
            System.out.println("You can't get the " + thingToAcquire + ". You don't have anywhere to put it and there's no way your parent's would let you keep it.");
        }
        
        // Output message that they can't get whatever else they typed in
        else
        {
            System.out.println("You can't get " + thingToAcquire);
        }
    }
    
    private boolean movePlayer(String placeToMoveTo)
    {   
        // Check if they have specified a location
        if (placeToMoveTo.equalsIgnoreCase("go") || placeToMoveTo.equals(""))
        {
            System.out.println("Go where?");
            return false; 
        }
        
        // Check to see if the player is trying to move through a valid Exit
        if (currentRoom.getExit1() != null && placeToMoveTo.equalsIgnoreCase(currentRoom.getExit1().getName()))
        {
            if (this.checkExit(currentRoom.getExit1()))
            {
                // Move the player and set the current room to the room that they have moved to
                currentRoom = currentRoom.getExit1().getDestination(); 
                return true;
            }
        }
        else if (currentRoom.getExit2() != null && placeToMoveTo.equalsIgnoreCase(currentRoom.getExit2().getName()))
        {
            if (this.checkExit(currentRoom.getExit2()))
            {
                // Move the player and set the current room to the room that they have moved to
                currentRoom = currentRoom.getExit2().getDestination(); 
                return true;
            }
        }
        else if (currentRoom.getExit3() != null && placeToMoveTo.equalsIgnoreCase(currentRoom.getExit3().getName()))
        {
            if (this.checkExit(currentRoom.getExit3()))
            {
                // Move the player and set the current room to the room that they have moved to
                currentRoom = currentRoom.getExit3().getDestination();
                return true;
            }
        }
        else if (currentRoom.getExit4() != null && placeToMoveTo.equalsIgnoreCase(currentRoom.getExit4().getName()))
        {
            if (this.checkExit(currentRoom.getExit4()))
            {
                // Move the player and set the current room to the room that they have moved to
                currentRoom = currentRoom.getExit4().getDestination();
                return true;
            }
        }
        else if (currentRoom.getSecretExit() != null && placeToMoveTo.equalsIgnoreCase(currentRoom.getSecretExit().getName()))
        {
            if (this.checkExit(currentRoom.getSecretExit()))
            {
                // Move the player and set the current room to the room that they have moved to
                currentRoom = currentRoom.getSecretExit().getDestination();
                return true;
            }
        }
        
        // They have not specified a valid exit
        
        else
        {
            System.out.println("It doesn't appear as though I can go there.");
            return false;
        }
        
        return false; 
    }
    
    private boolean checkExit(Exit exit)
    {
        // Check if there's a creature that's blocking the Exit
        if(currentRoom.getCreature() != null && exit.getCreatureBlocks())
        {
            System.out.println("You attempt to leave, but the " + currentRoom.getCreature().getName() + " blocks the way.");
            return false; 
        }
        
        // Check if the player has the necessary Item to use the Exit
        if(exit.getRequiredItem() != null && !player.isItemInInventory(exit.getRequiredItem()))
        {
            System.out.println("You do not possess the necessary Item to pass through this Exit.");
            return false; 
        }
        
        // There's nothing preventing the player from going through the Exit. 
        System.out.println(exit.getTransition());
        return true; 
    }
    
    private void useItem(String itemToUse)
    {
        
        // Check if they didn't specify an item.
        
        if(itemToUse.equalsIgnoreCase("") || itemToUse.equalsIgnoreCase("use"))
        {
            System.out.println("Use what?");
            return; 
        }
        
        // Get a reference to the item
        
        Item item = player.getItemFromInventory(itemToUse);
        
        // If the reference is not null (i.e., the Item exists)
        
        if (item != null)
        {
            // Display a message
            System.out.println("You use the " + item.getName());
            
            // Check if using the item will destroy a creature
            if (currentRoom.getCreature() != null && currentRoom.getCreature().getItemToDestroy() != null && currentRoom.getCreature().getItemToDestroy() == item)
            {
                // Display the text for defeating the creature. 
                System.out.println(currentRoom.getCreature().getDefeatedText()); 
                currentRoom.setCreature(null);
                
                // Remove the item from the Player's inventory.
                player.removeItemFromInventory(item);
            }
        }
        
        // The player does not have the specified item
        
        else
        {
            System.out.println("There is no " + itemToUse + " in your inventory.");
        }
    }
    
    private void processInputUntilRoomChange()
    {
        // Loop until we want to stop
        while(true)
        {
            // Get the user input
            System.out.print("> ");
            String input = scan.nextLine(); 
            
            // Determine which command they used and act accordingly
            if (input.startsWith("help"))
            {
                this.displayCommands();
            }
            else if (input.startsWith("look"))
            {
                this.displayDescription(input.substring(input.indexOf(" ") + 1));
            }
            else if (input.startsWith("get"))
            {
                this.acquireItem(input.substring(input.indexOf(" ") + 1));
            }
            else if (input.startsWith("go"))
            {
                if(this.movePlayer(input.substring(input.indexOf(" ") + 1)))
                {
                    break; 
                }
            }
            else if (input.startsWith("use"))
            {
                this.useItem(input.substring(input.indexOf(" ") + 1));                 
            }
            else if (input.startsWith("inventory"))
            {
                System.out.print(player.listInventory());
            }
            
            // The player did not enter a valid command.
            
            else
            {
                System.out.println("I don't know how to " + input);
            }
        } 
    }
}
