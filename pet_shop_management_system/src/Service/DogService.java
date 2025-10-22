package Service;
public class DogService implements PetService{
    
    
    private static DogService dogService;

    private DogService() {
    }

    public static DogService getInstance() {
        if (dogService == null) {
            dogService = new DogService();
        }
        return dogService;
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