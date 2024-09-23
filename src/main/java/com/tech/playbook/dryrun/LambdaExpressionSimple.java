package com.tech.playbook.dryrun;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaExpressionSimple {

    public static void main(String[] args) {
        String input = "tech-playbook-hub";
        Map<Character, Long> stringCount = input.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        stringCount.entrySet().stream().filter(entity->entity.getValue()>1).forEach(value-> System.out.println(value.getKey() + ":" +value.getValue()));
    }
    
}
