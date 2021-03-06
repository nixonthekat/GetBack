/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import api.WebsitePlugin;
import getback.GetBack;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Bryce
 */
public class Disable extends Command {

    public Disable() {
        super("disable", "Disables a website plugin.");
    }

    @Override
    public void execute(String command, String[] args) {
        if (args.length == 0) {
            System.out.println("Incorrect usage: disable {name/id}");
        }
        
        if (StringUtils.isNumeric(args[0])) {
            int stop = Integer.parseInt(args[0]);
            int index = 0;
            for (WebsitePlugin plugin : GetBack.getInstance().getWebsitePluginLoader().getWebsitePlugins().values()){
                index += 1;
                if (index == stop){
                    plugin.disablePlugin();
                }
            }
        } else {
            WebsitePlugin plugin = GetBack.getInstance().getWebsitePluginLoader().getWebsitePlugins().get(args[0]);
            plugin.disablePlugin();
        }
    }

}
