package v2.logic;

public class LinkDeveloper {
    public String linkDeveloper(String assemblyNumber,String sys){

        String assemblyLink;
        String prefix ="https://10.144.127.109/projects/";
        String ourSistem = "";
        if (sys.equals("EMPD")){
            ourSistem = "iemd-pp/workpackages/";
        }
        else {
            ourSistem ="rrdgp/work_packages/";
        }

        String suffix = "/activity";
        assemblyLink = prefix + ourSistem + assemblyNumber + suffix;
        return assemblyLink;
    }
}
