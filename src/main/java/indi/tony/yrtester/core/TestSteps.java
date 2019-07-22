package indi.tony.yrtester.core;

public class TestSteps {
    private int step_id;
    private int case_id;
    private String step_description;
    private String object_key;
    private String object_value;
    private String action_key;
    private String action_value;
    private String verify_key;
    private String verify_value;

    public String getStep_description() {
        return step_description;
    }

    public void setStep_description(String step_description) {
        this.step_description = step_description;
    }

    public int getStep_id() {
        return step_id;
    }

    public void setStep_id(int step_id) {
        this.step_id = step_id;
    }

    public String getObject_key() {
        return object_key;
    }

    public void setObject_key(String object_key) {
        this.object_key = object_key;
    }

    public String getObject_value() {
        return object_value;
    }

    public void setObject_value(String object_value) {
        this.object_value = object_value;
    }

    public String getAction_key() {
        return action_key;
    }

    public void setAction_key(String action_key) {
        this.action_key = action_key;
    }

    public String getAction_value() {
        return action_value;
    }

    public void setAction_value(String action_value) {
        this.action_value = action_value;
    }

    public String getVerify_key() {
        return verify_key;
    }

    public void setVerify_key(String verify_key) {
        this.verify_key = verify_key;
    }

    public String getVerify_value() {
        return verify_value;
    }

    public void setVerify_value(String verify_value) {
        this.verify_value = verify_value;
    }

    public int getCase_id() {
        return case_id;
    }

    public void setCase_id(int case_id) {
        this.case_id = case_id;
    }
}
