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
        
        String[] coles = {
            "coles-shepard-avocados-1-each-5900891",
            "tassal-fresh-tassie-salmon-portions-skin-off-300g-5285280",
            "coles-free-range-eggs-12-pack-700g-9453478",
            "coles-2-ply-facial-tissues-224-pack-9161519",
            "helgas-white-loaf-700g-1089939",
            "coles-full-cream-milk-2l-439693",
            "coles-rspca-approved-free-range-chicken-breast-fillet-small-pack-approx.-600g-3228730",
            "don-leg-ham-shaved-200g-6284567",
            "cobram-estate-extra-virgin-olive-oil-classic-375ml-9389517",
            "morning-fresh-lemon-dishwashing-liquid-900ml-9735935",
            "capilano-pure-honey-upside-down-squeeze-500g-9247578",
            "libra-pads-ultra-thin-regular-wings-14-pack-6811527",
            "quilton-3-ply-classic-white-toilet-paper-20-pack-7758634"
        };

        String[] woolies = {
            "avocado",
            "tassal-atlantic-salmon-skin-off",
            "simply-eggs-12-extra-large-cage-free-eggs",
            "quilton-2ply-tissue-hypo-allergenic",
            "helga-s-soft-white-loaf",
            "woolworths-full-cream-milk",
            "woolworths-rspca-approved-chicken-breast-fillet-skinless-small",
            "don-leg-ham-shaved",
            "cobram-estate-olive-oil-extra-virgin",
            "morning-fresh-dishwashing-liquid-lemon-lemon-super-strength",
            "capilano-100-pure-australian-honey-squeeze",
            "libra-ultra-thins-pads-wings-regular",
            "quilton-white-3-ply-toilet-paper-white-180-sheets"
        };
        
        String[] aldi = {
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

        for(String colesItem : coles){
            colesService.add(colesItem);
        }

        for(String wooliesItem: woolies){
            wooliesService.add(wooliesItem);
        }

        // for(String item: items2){
        //     aldiService.fetchAdd(item);
        // }
        System.out.println("done FCKKK FINALLY!");
    }
}
