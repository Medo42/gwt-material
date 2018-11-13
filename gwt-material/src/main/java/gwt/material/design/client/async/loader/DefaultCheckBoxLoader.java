package gwt.material.design.client.async.loader;

import gwt.material.design.client.ui.MaterialCheckBox;
import gwt.material.design.client.ui.MaterialLoader;
import gwt.material.design.client.ui.MaterialPanel;

public class DefaultCheckBoxLoader implements AsyncDisplayLoader<Boolean> {

    private MaterialCheckBox checkBox;
    private MaterialPanel panel;
    private MaterialLoader loader;

    protected DefaultCheckBoxLoader() {}

    public DefaultCheckBoxLoader(MaterialCheckBox checkBox) {
        this.checkBox = checkBox;

        setupLoader();
    }

    protected void setupLoader() {
        loader = new MaterialLoader();
        loader.setContainer(checkBox);
    }

    @Override
    public void loading() {
        checkBox.setEnabled(false);
        loader.show();
    }

    @Override
    public void success(Boolean result) {
        checkBox.setValue(result, true);
    }

    @Override
    public void failure(String error) {

    }

    @Override
    public void finalize() {
        checkBox.setEnabled(true);
        loader.hide();
    }
}