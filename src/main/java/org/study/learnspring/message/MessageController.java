package org.study.learnspring.message;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessageSource messageSource;

    public MessageController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping(value="/default")
    public Map<String, String> defaultMessage() {
        Map<String, String> map = new HashMap<>();
        map.put("error", messageSource.getMessage("error", null, Locale.getDefault()));
        return map;
    }

    @GetMapping(value="/en")
    public Map<String, String> enMessage() {
        Map<String, String> map = new HashMap<>();
        map.put("error", messageSource.getMessage("error", null, Locale.ENGLISH));
        return map;
    }

    @GetMapping(value="/msg")
    public Map<String, String> msg() {
        Map<String, String> map = new HashMap<>();
        map.put("error", messageSource.getMessage("error.key", new String[]{"ERROR_CODE: 0000"}, LocaleContextHolder.getLocale()));
        return map;
    }
}
