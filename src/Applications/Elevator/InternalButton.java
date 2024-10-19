package Applications.Elevator;

public class InternalButton {
    InternalButtonDispatcher dispatcher;
    int[] buttons = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    boolean isSelected;
    public InternalButton(InternalButtonDispatcher dispatcher){
        this.dispatcher = dispatcher;
    }
    public void pressButton(int dest, Elevator elevator){
        boolean found = false;
        for(int i = 0; i<10; i++){
            if(buttons[i] == dest){
                found = true;
                break;
            }
        }
        if(!found)return;
        this.dispatcher.submitInternalRequest(dest, elevator);
    }
}