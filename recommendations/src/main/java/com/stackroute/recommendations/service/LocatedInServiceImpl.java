package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Area;
import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.repository.LocatedInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class LocatedInServiceImpl implements LocatedInService
{
    LocatedInRepository locatedInRepository;

    @Autowired
    public LocatedInServiceImpl(LocatedInRepository locatedInRepository) {
        this.locatedInRepository = locatedInRepository;
    }


    @Override
    public StorageUnit createAreaRelationship(long warehouseId, String area) {
        return locatedInRepository.createRelationship(warehouseId,area);

    }

    @Override
    public Partition createRelationshipArea(Long pid, String area) {
        return locatedInRepository.createRelationshipArea(pid,area);
    }

    @Override
    public Partition deleteRelationshipArea() {
        return locatedInRepository.deleteRelationshipArea();
    }

//    @Override
//    public Partition createRelationshipCost(String cost, String area) {
//        return locatedInRepository.createRelationshipCost(cost,area);
//    }

    @Override
    public Collection<StorageUnit> createRecommendationSqft() throws Exception{

        ArrayList<Long> list1=locatedInRepository.getAllPartitionSqft();
        System.out.println(list1);
        ArrayList<Long> list=locatedInRepository.getPartitionSqft();
        System.out.println(list);

        for(int i=0;i<list1.size();i++)
        {
            for (int j = 0; j < list.size(); j++)
            {
                if (list1.get(i).equals(list.get(j)))
                {
                    System.out.println("inside list");
                    System.out.println(list1.get(i));
                }
            }
        }
        return locatedInRepository.createRecommendationSqft();
    }

    @Override
    public Collection<Area> createRecommendationLocation() throws Exception
    {
        ArrayList<String> list2=locatedInRepository.getAllPartitionLocation();
        System.out.println(list2);
        ArrayList<String> list3=locatedInRepository.getPartitionLocation();
        System.out.println(list3);

        for(int i=0;i<list2.size();i++)
        {
            for (int j = 0; j < list3.size(); j++)
            {
                if (list2.get(i).equals(list3.get(j)))
                {
                    //System.out.println("inside list");
                    System.out.println(list3.get(j));
                }
            }
        }

        return locatedInRepository.createRecommendationLocation();
    }

}


