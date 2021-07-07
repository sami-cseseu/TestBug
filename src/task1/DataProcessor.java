package task1;
public class DataProcessor {

    public String getRawParameter(String name, String def) {
        try {
            return getRawParameter(name);
        } catch (Exception e) {
            return def;
        }
    }
    
    public String getRawParameter(String name) throws ParameterNotFoundException {
        String values = Request.getParameterValues(name);
        if (values == null) {
            throw new ParameterNotFoundException(name + " not found");
        } else if (values.length() == 0) {
            throw new ParameterNotFoundException(name + " was empty");
        }
        return (values);
    }

}