package endpoint;

public class RoutesURL {
    public static String base_url = "https://api.github.com";
    public static String post_url = base_url + "/user/repos";
    public static String get_url = base_url + "/repos/{owner}/{repo}";
    public static String update_url = base_url + "/repos/{owner}/{repo}";
    public static String delete_url = base_url + "/repos/{owner}/{repo}";
}
