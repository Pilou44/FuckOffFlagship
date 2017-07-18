package poc.fuckoffflagship.data.beans;

/**
 * Created by Guillaume on 12/07/2017.
 */

public class Disney {
    private String mName;
    private boolean isChecked;

    public Disney(String name, Boolean isChecked) {
        mName = name;
        this.isChecked = isChecked;
    }

    public Disney(String name) {
        mName = name;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Boolean isChecked() {
        return isChecked;
    }

    public void setChecked(Boolean checked) {
        isChecked = checked;
    }
}
