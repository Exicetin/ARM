package v2.logic;

public class LinkDeveloper {
    public String linkDeveloper(String assemblyNumber){
        String assemblyLink;
        String prefix ="https://10.144.127.109/projects/iemd-pp/workpackages/";
        String suffix = "/activity";
        assemblyLink = prefix + assemblyNumber + suffix;
        return assemblyLink;
    }
}
