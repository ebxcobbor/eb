/*
 * This file is part of Sui.
 *
 * Sui is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Sui is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Sui.  If not, see <https://www.gnu.org/licenses/>.
 *
 * Copyright (c) 2021 Sui Contributors
 */

package rikka.sui.resource;

import java.util.HashMap;
import java.util.Locale;

import static rikka.sui.resource.Res.string.COUNT;
import static rikka.sui.resource.Res.string.brackets_format;
import static rikka.sui.resource.Res.string.close;
import static rikka.sui.resource.Res.string.grant_dialog_button_allow_always;
import static rikka.sui.resource.Res.string.grant_dialog_button_allow_one_time;
import static rikka.sui.resource.Res.string.grant_dialog_button_deny;
import static rikka.sui.resource.Res.string.grant_dialog_button_deny_and_dont_ask_again;
import static rikka.sui.resource.Res.string.management_title;
import static rikka.sui.resource.Res.string.notification_channel_group_name;
import static rikka.sui.resource.Res.string.notification_show_management_title;
import static rikka.sui.resource.Res.string.notification_show_management_text;
import static rikka.sui.resource.Res.string.permission_allowed;
import static rikka.sui.resource.Res.string.permission_ask;
import static rikka.sui.resource.Res.string.permission_denied;
import static rikka.sui.resource.Res.string.permission_description;
import static rikka.sui.resource.Res.string.permission_hidden;
import static rikka.sui.resource.Res.string.permission_warning_template;

public class Strings {

    private static final HashMap<String, String[]> STRINGS = new HashMap<>();

    static {
        String[] array;

        // Permission related texts can be found in packages/apps/PermissionController/res/values-[locale]/strings.xml

        array = new String[COUNT];
        array[permission_warning_template] = "?????????<b>%1$s</b>%2$s??????";
        array[permission_description] = "?????????????????????????????????";
        array[grant_dialog_button_allow_always] = "????????????";
        array[grant_dialog_button_allow_one_time] = "???????????????";
        array[grant_dialog_button_deny] = "??????";
        array[grant_dialog_button_deny_and_dont_ask_again] = "????????????????????????";
        array[brackets_format] = "%1$s???%2$s???";
        array[management_title] = "??????????????????";
        array[close] = "??????";
        array[permission_allowed] = "??????";
        array[permission_denied] = "??????";
        array[permission_hidden] = "??????";
        array[permission_ask] = "??????";
        array[notification_channel_group_name] = "??????????????????";
        array[notification_show_management_title] = "?????????????????????????????????";
        array[notification_show_management_text] = "???????????????????????????????????????";
        Strings.STRINGS.put("zh-CN", array);

        array = new String[COUNT];
        array[permission_warning_template] = "????????????%1$s???%2$s??????";
        array[permission_description] = "??????????????? Root ??????";
        array[grant_dialog_button_allow_always] = "????????????";
        array[grant_dialog_button_allow_one_time] = "??????????????????";
        array[grant_dialog_button_deny] = "??????";
        array[grant_dialog_button_deny_and_dont_ask_again] = "????????????????????????";
        array[brackets_format] = "%1$s???%2$s???";
        array[management_title] = "?????????????????????";
        array[close] = "??????";
        array[permission_allowed] = "??????";
        array[permission_denied] = "??????";
        array[permission_hidden] = "??????";
        array[permission_ask] = "??????";
        array[notification_channel_group_name] = "??????????????????";
        array[notification_show_management_title] = "????????????????????????????????????";
        array[notification_show_management_text] = "??????????????????????????????????????????";
        Strings.STRINGS.put("zh", array);

        array = new String[COUNT];
        array[permission_warning_template] = "Allow <b>%1$s</b> to %2$s?";
        array[permission_description] = "have the full access of the device";
        array[grant_dialog_button_allow_always] = "Allow all the time";
        array[grant_dialog_button_allow_one_time] = "Only this time";
        array[grant_dialog_button_deny] = "Deny";
        array[grant_dialog_button_deny_and_dont_ask_again] = "Deny, don't ask again";
        array[brackets_format] = "%1$s (%2$s)";
        array[management_title] = "Superuser management";
        array[close] = "Close";
        array[permission_allowed] = "Allowed";
        array[permission_denied] = "Denied";
        array[permission_hidden] = "Hidden";
        array[permission_ask] = "Ask";
        array[notification_channel_group_name] = "Show management";
        array[notification_show_management_title] = "You have entered \"Developer options\"";
        array[notification_show_management_text] = "Tap to show superuser management";
        Strings.STRINGS.put("en", array);
    }

    public static String get(int res) {
        return getDefaultString(res, Locale.getDefault());
    }

    private static String[] getStringsMap(Locale locale) {
        String language = locale.getLanguage();
        String region = locale.getCountry();

        // fully match
        locale = new Locale(language, region);
        for (String l : STRINGS.keySet()) {
            if (locale.toString().equals(l.replace('-', '_'))) {
                return STRINGS.get(l);
            }
        }

        // match language only keys
        locale = new Locale(language);
        for (String l : STRINGS.keySet()) {
            if (locale.toString().equals(l)) {
                return STRINGS.get(l);
            }
        }

        // match a language_region with only language
        for (String l : STRINGS.keySet()) {
            if (l.startsWith(locale.toString())) {
                return STRINGS.get(l);
            }
        }

        if (STRINGS.containsKey("en")) {
            return STRINGS.get("en");
        }
        throw new NullPointerException();
    }

    private static String getDefaultString(int res, Locale locale) {
        if (locale == null) {
            locale = Locale.getDefault();

            if (locale == null)
                locale = Locale.ENGLISH;
        }

        return getStringsMap(locale)[res];
    }

}