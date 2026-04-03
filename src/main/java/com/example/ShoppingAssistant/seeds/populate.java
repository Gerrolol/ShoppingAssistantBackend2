package com.example.ShoppingAssistant.seeds;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.ShoppingAssistant.service.aldiService;
import com.example.ShoppingAssistant.service.colesService;
import com.example.ShoppingAssistant.service.wooliesService;

@Component
public class populate implements CommandLineRunner {
    private final aldiService aldiService;
    private final colesService colesService;
    private final wooliesService wooliesService;

    populate(aldiService aldiService, colesService colesService, wooliesService wooliesService){
        this.aldiService = aldiService;
        this.colesService = colesService;
        this.wooliesService = wooliesService;
    }
    
    @Override
    public void run(String... args) throws Exception {
        String[] items1 = {
            "Avocado 1KG",
            "Salmon",
            "eggs Dozen",
            "Tissue",
            "bread",
            "Milk 2L",
            "Chicken Breast",
            "Ham",
            "Olive Oil",
            "Detergent",
            "Honey",
            "Pads",
            "toilet Paper"
        };
        
        String[] items2 = {
            "no-brand-avocados-1kg-000000000000380177",
            "the-fishmonger-fresh-tasmanian-salmon-fillets-skin-off-2-pack-260g-000000000000401066",
            "lodge-farms-cage-eggs-700g-000000000000399451",
            "confidence-assorted-facial-tissues-2ply-224-pack-000000000421199001",
            "bakers-life-bakehouse-light-rye-bread-680g-000000000000400367",
            "farmdale-full-cream-milk-2l-000000000000398689",
            "broad-oak-farms-free-range-chicken-breast-fillets-000000000000599397",
            "berg-leg-ham-shaved-100g-000000000000399618",
            "moro-extra-virgin-olive-oil-500ml-000000000000657967",
            "oh-so-natural-organic-organic-raw-honey-400g-000000000000602677",
            "libra-assorted-extra-pads-000000000403206001",
            "confidence-toilet-tissue-hypoallergenic-8-pack-000000000000421253"
        };

        for(String item : items1){
            colesService.add(item);
            wooliesService.add(item);
        }

        for(String item: items2){
            aldiService.fetchAdd(item);
        }
        System.out.println("done FCKKK FINALLY!");
    }
}
