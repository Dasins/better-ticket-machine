/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class TicketMachine
{
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    //  Determine if the machine is a prize machine. true = Prize Machine.
    private boolean prizeMachine;

    /**
     * Create a machine that issues tickets of the given price.
     */
    public TicketMachine(int cost, boolean setMachineType)
    {
        prizeMachine = setMachineType;
        price = cost;
        balance = 0;
        total = 0;
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice()
    {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance()
    {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount)
    {
        if(amount > 0) {
            balance = balance + amount;
        }
        else {
            System.out.println("Use a positive amount rather than: " +
                               amount);
        }
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket()
    {
        if(balance >= price) {
            //check if the machine has prizes.
            if (prizeMachine == true) {
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();
                
                // Simulate the printing of a free ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Free Ticket");
                System.out.println("# Congratulations");
                System.out.println("# You won a free ticket");
                System.out.println("##################");
                System.out.println();
    
                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
            }
            else{
                // Simulate the printing of a ticket.
                System.out.println("##################");
                System.out.println("# The BlueJ Line");
                System.out.println("# Ticket");
                System.out.println("# " + price + " cents.");
                System.out.println("##################");
                System.out.println();
                
                // Update the total collected with the price.
                total = total + price;
                // Reduce the balance by the prince.
                balance = balance - price;
            }
        }
        else {
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");          
        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance()
    {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }
    
    /**
     * If the machine isn't in use, 
     * empty it and return the total collection.
     * If machine is in use. 
     * Print an advertisement on the screen.
     */
    public int emptyMachine()
    {
        int amountToCollect = -1;
        if (balance != 0){
           System.out.println("Hay una operaci�n en curso.");
           System.out.println("Por favor, int�ntelo m�s tarde.");
           amountToCollect = -1;
        }
        else{
            amountToCollect = total;
            total = 0;
        }
        return amountToCollect;
    }
}