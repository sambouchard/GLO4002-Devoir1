package devoir1;

import java.util.HashMap;
import java.util.Map;

class WaitingListFactory {

    static WaitingList instantiateWaitingList(TriageType triageType){
            switch (triageType){
                case FIFO: return new FifoWaitingList();
                case GRAVITY:return new GravityWaitingList();
                default: throw new IllegalArgumentException("Invalid Triage type");
            }
    }
}
