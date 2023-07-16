package mp4.Custom;

import mp1.Methods;

import java.util.Collections;
import java.util.List;

public class PillOrganizer implements Methods {
    private Integer maxCapacity;
    private List<String> drugList;

    private Integer diameterOfPillSection;

    public PillOrganizer(Integer maxCapacity, List<String> drugList, Integer diameterOfPillSection) throws Exception {
        checkInteger(maxCapacity);
        checkIfNotNull(drugList);
        checkInteger(diameterOfPillSection);

        this.maxCapacity = maxCapacity;
        this.drugList = drugList;
        this.diameterOfPillSection = diameterOfPillSection;
    }

    public Integer getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(Integer maxCapacity) throws Exception {
        checkInteger(maxCapacity);
        if(maxCapacity < 1){
            throw new Exception("Pill organizer can have at least 1 slot for pill");
        }
        this.maxCapacity = maxCapacity;
    }

    public List<String> getDrugList() {
        return Collections.unmodifiableList(drugList);
    }

    public void addDrug(String drug,Integer diameterOfPill) throws Exception {
        if(drugList.size() != getMaxCapacity())
        {
            checkString(drug);
            drugList.add(drug);
        }
        else if(diameterOfPill > diameterOfPillSection)
        {
            throw new Exception("You cannot add this pill, it`s too huge");
        }

        else {
            throw new Exception("This pill organizer is full, use another one ore modify this one");
        }

    }

    public Integer getDiameterOfPillSection() {
        return diameterOfPillSection;
    }

    public void setDiameterOfPillSection(Integer diameterOfPillSection) throws Exception {
        checkInteger(diameterOfPillSection);
        if(diameterOfPillSection > 100 || diameterOfPillSection < 5)
        {
            throw new Exception("Diameter of this pill organizer can be changed from 5 to 100");
        }
        this.diameterOfPillSection = diameterOfPillSection;
    }
}
