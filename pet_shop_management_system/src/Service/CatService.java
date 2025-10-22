package Service;
public class CatService implements PetService{
    private static CatService catService;

     private CatService() {
    }


    public static CatService getInstance(){
        if(catService == null) {
            catService = new CatService();
        }
        return catService;
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