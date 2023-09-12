


/**
 *
 * @author joshuahootman
 */
public class Transaction {
    boolean approved;
    String bankName;
   
    
  public Transaction(String name){
      bankName = name;
  }
          
    
    public void Approve (boolean in){
        approved = in;
    }
}
