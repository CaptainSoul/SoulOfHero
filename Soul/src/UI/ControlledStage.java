package UI;

public abstract class ControlledStage {
	protected StageController myController;
	
	public void setStageController(StageController stageController) {
		this.myController = stageController;
	}
	
	public void goToMain() {
		myController.setStage(MainApp.mainViewID);
	}
}
