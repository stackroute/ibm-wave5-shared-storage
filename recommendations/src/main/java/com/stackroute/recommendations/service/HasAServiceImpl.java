package com.stackroute.recommendations.service;

import com.stackroute.recommendations.domain.Partition;
import com.stackroute.recommendations.domain.StorageUnit;
import com.stackroute.recommendations.repository.HasARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;

@Service
public class HasAServiceImpl implements HasAService
{
    HasARepository hasARepository;

    @Autowired
    public HasAServiceImpl(HasARepository hasARepository) {
        this.hasARepository = hasARepository;
    }

    @Override
    public StorageUnit createStorageUnitRelationship(long warehouseId, long pid) {
        return hasARepository.createRelationship(warehouseId,pid);
    }

        @Override
    public Collection<StorageUnit> recommendationCost() throws Exception {

        ArrayList<Long> list =hasARepository.getCost();
        ArrayList<Long> list1=hasARepository.getPartitionId();
        System.out.println(list);
        System.out.println(list1);

            System.out.println("Inside Cost");

        Collection<Partition> collection=new ArrayList<>();
        //Collection<StorageUnit> collection1=new ArrayList<>();
        Collection<StorageUnit> finalList=new ArrayList<>();


            for(int i=0;i<list1.size();i++){
               // System.out.println(list1.get(i));
                for(int j=0;j<list.size();j++){
                    if(i==j){
                       // System.out.println( list.get(j));
                        System.out.println("Outside If");
                        if (list.get(j) >= 500 && list.get(j) <= 1000)
                        {
                            System.out.println( list.get(j));
                            System.out.println("500-1000");
                            collection = hasARepository.recommendationCostRange0();
                        } else if (list.get(j) > 1000 && list.get(j) <= 2000) {
                            System.out.println("1000-2000");
                            collection = hasARepository.recommendationCostRange1();
                        } else if (list.get(j) > 2000 && list.get(j) <= 3000) {
                            System.out.println("2000-3000");
                            collection= hasARepository.recommendationCostRange2();
                        } else if (list.get(j) > 3000 && list.get(j) <= 4000) {
                            System.out.println("3000-4000");
                            collection= hasARepository.recommendationCostRange3();
                        } else if (list.get(j) > 4000 && list.get(j) <= 5000) {
                            System.out.println("4000-5000");
                            collection= hasARepository.recommendationCostRange4();
                        } else if (list.get(j) > 5000 && list.get(j) <= 6000) {
                            System.out.println("5000-6000");
                            collection= hasARepository.recommendationCostRange5();
                        }

                    }
                }
            }
            //System.out.println(finalList);
            System.out.println("outside for loop");
            return finalList;

    }
}
