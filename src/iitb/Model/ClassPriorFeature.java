/*
 * Created on Dec 2, 2004
 *
 */
package iitb.Model;

import iitb.CRF.DataSequence;

/**
 * @author sunita
 *
 */
public class ClassPriorFeature extends FeatureTypes {
    private static final long serialVersionUID = 16L;
    transient int thisClassId;
    /**
     * @param m
     */
    public ClassPriorFeature(Model m) {
        super(m);
    }

    /* (non-Javadoc)
     * @see iitb.Model.FeatureTypes#startScanFeaturesAt(iitb.CRF.DataSequence, int, int)
     */
    public boolean startScanFeaturesAt(DataSequence data, int prevPos, int pos) {
        thisClassId = model.numStates()-1;
        return hasNext();
    }

    /* (non-Javadoc)
     * @see iitb.Model.FeatureTypes#hasNext()
     */
    public boolean hasNext() {
        return thisClassId >= 0;
    }

    /* (non-Javadoc)
     * @see iitb.Model.FeatureTypes#next(iitb.Model.FeatureImpl)
     */
    public void next(FeatureImpl f) {
        f.yend = thisClassId;
        String name="";
        if (featureCollectMode) {
            name = "Bias " + thisClassId;
        }
        setFeatureIdentifier(thisClassId,thisClassId,name,f);
        thisClassId--;
    }

}