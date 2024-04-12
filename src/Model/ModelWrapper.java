package Model;

import java.io.Serializable;

public class ModelWrapper implements Serializable {
	private PerspectiveModel perspectiveModel1, perspectiveModel2;
	private ImageModel imageModel;

    public ModelWrapper(PerspectiveModel perspectiveModel1, PerspectiveModel perspectiveModel2, ImageModel imageModel) {
		this.perspectiveModel1 = perspectiveModel1;
		this.perspectiveModel2 = perspectiveModel2;
		this.imageModel =imageModel;
    }

    public PerspectiveModel getPerspectiveModel1() {
        return perspectiveModel1;
    }

    public PerspectiveModel getPerspectiveModel2() {
        return perspectiveModel2;
    }
    
    public ImageModel getImageModel() {
    	return imageModel;
    }
    
}
