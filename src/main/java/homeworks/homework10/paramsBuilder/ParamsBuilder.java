package homeworks.homework10.paramsBuilder;

import homeworks.homework10.paramsBuilder.enums.Language;

import java.util.HashMap;

import static homeworks.homework10.paramsBuilder.enums.Params.*;

public class ParamsBuilder {

    private HashMap<String, String> params = new HashMap<String, String>();
    private ParamsBuilder paramsBuilder;

    public ParamsBuilder text(String text) {
        paramsBuilder.params.put(TEXT.param, text);
        return this;
    }

    public ParamsBuilder options(String options) {
        paramsBuilder.params.put(OPTIONS.param, options);
        return this;
    }

    public ParamsBuilder language(Language language) {
        paramsBuilder.params.put(LANG.param, language.value);
        return this;
    }
}
