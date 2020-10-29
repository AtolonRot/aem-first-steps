package com.adobe.aem.guides.wknd.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Source;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Model(adaptables = SlingHttpServletRequest.class)
public class RetoShenModel {
    @Inject
    @Source("sling-object")
    private ResourceResolver resourceResolver;

    @SlingObject
    private Resource currentResource;

    @Inject
    private Page currentPage;

    private List<PageDetail> datafromModelList = new ArrayList<PageDetail>();

    @PostConstruct
    public void init() {
        try {
            //      PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
            //       Optional<Page> page = Optional.ofNullable(pageManager)
            //               .map(pm -> pm.getContainingPage(currentResource));
            //         if (page.isPresent()) {
            //          datafromModelList.addAll(iteratorToList(page.get().listChildren()));
            if (currentPage != null) {
                datafromModelList.addAll(iteratorToList(currentPage.listChildren()));
            }
            //       }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private List<PageDetail> iteratorToList(Iterator<Page> iterator) {
        Iterable<Page> iterable = () -> iterator;
        return StreamSupport.stream(iterable.spliterator(), false).map(r -> new PageDetail(r.getTitle(), r.getPath())).collect(Collectors.toList());
    }

    public List<PageDetail> getDatafromModelList() {
        return datafromModelList;
    }

}
