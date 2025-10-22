package Service;
public class OtherPetService implements PetService{
    
    private static OtherPetService otherPetService;

    private OtherPetService() {
    }

    public static OtherPetService getInstance() {
        if (otherPetService == null) {
            otherPetService = new OtherPetService();
        }
        return otherPetService;
    }

    @Override
    public void add() {
        // TODO Auto-generated method stub
        
    }   

    @Override
    public void remove() {
        // TODO Auto-generated method stub
        
    }
    


    @Override
    public void find() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void change() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void viewAll() {
        // TODO Auto-generated method stub
        
    }


}