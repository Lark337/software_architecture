package d1.ModelChanger;

import d1.ModelChanger.ModelChanger;
import d1.ModelChanger.ModelChangedObserver;
import d1.ModelElements.Camera;
import d1.ModelElements.Flash;
import d1.ModelElements.PoligonalModel;
import d1.ModelElements.Scene;

public class ModelStore implements ModelChanger{

    public PoligonalModel models;
    public Scene scenes;
    public Flash flashes;
    public Camera cameras;
    private ModelChangedObserver changeObservers;

    public ModelStore(){
        
    }

    public Scene getScene(Integer n){
        return this.scenes;
    }
    
    @Override
    public void notifyChange(ModelChanger sender){

    }

    
}


