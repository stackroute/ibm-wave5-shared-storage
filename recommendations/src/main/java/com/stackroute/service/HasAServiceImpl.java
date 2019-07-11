package com.stackroute.service;

import com.stackroute.model.StorageUnit;
import com.stackroute.repository.HasARepository;
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
    public Collection<StorageUnit> getRelationship() {
        return hasARepository.getRelationship();
    }

    @Override
    public StorageUnit createStorageUnitRelationship(long warehouseId, long pid) {
        return hasARepository.createRelationship(warehouseId,pid);
    }

    @Override
    public Collection<StorageUnit> recommendationSqft() throws Exception {

        ArrayList<Long> list =hasARepository.getSqft();
        ArrayList<Long> list1=hasARepository.getPartitionId();
        System.out.println(list);
        System.out.println(list1);

            //System.out.println("Inside Cost");


            Collection<StorageUnit> collection=new ArrayList<>();
            Collection<StorageUnit> finalList=new ArrayList<>();

            Collection newList=new ArrayList<>();

            for(int i=0;i<list1.size();i++){
                System.out.println("pid "+list1.get(i));
                for(int j=0;j<list.size();j++){
                    if(i==j) {
                        System.out.println("sqft " + list.get(j));
                        if (list.get(j) >= 30 && list.get(j) <= 50) {
                            System.out.println("1st Range 30 to 50");
                            collection = hasARepository.recommendationSqftRange0(list1.get(i));
                            for (StorageUnit s : collection) {
                                finalList.add(s);
                            }
                        } else if (list.get(j) > 50 && list.get(j) <= 100) {
                            System.out.println("2nd range 50 to 100");
                            collection = hasARepository.recommendationSqftRange1(list1.get(i));
                            for (StorageUnit s : collection) {
                                finalList.add(s);
                            }
                        } else if (list.get(j) > 100 && list.get(j) <= 200) {
                            System.out.println("3rd range 100 to 200");
                            collection = hasARepository.recommendationSqftRange2(list1.get(i));
                            System.out.println(collection + "" + list1.get(i));
                            for (StorageUnit s : collection) {
                                finalList.add(s);
                            }

                        } else if (list.get(j) > 200 && list.get(j) <= 300) {
                            System.out.println("4th range 200 to 300");
                            collection = hasARepository.recommendationSqftRange3(list1.get(i));
                            for (StorageUnit s : collection) {
                                finalList.add(s);
                            }
                        } else if (list.get(j) > 300 && list.get(j) <= 500) {
                            System.out.println("5th range 300 to 500");
                            collection = hasARepository.recommendationSqftRange4(list1.get(i));
                            for (StorageUnit s : collection) {
                                finalList.add(s);
                            }
                        } else if (list.get(j) > 500 && list.get(j) <= 1000) {
                            System.out.println("6th range 500 to 1000");
                            collection = hasARepository.recommendationSqftRange5(list1.get(i));
                            for (StorageUnit s : collection) {
                                finalList.add(s);
                            }
                        } else if (list.get(j) > 1000 && list.get(j) <= 1500) {
                            System.out.println("7th range 1000 to 1500");
                            collection = hasARepository.recommendationSqftRange6(list1.get(i));
                            for (StorageUnit s : collection) {
                                finalList.add(s);
                            }

                        } else if (list.get(j) > 1500 && list.get(j) <= 2000) {
                            System.out.println("8th range 1500 to 2000");
                            collection = hasARepository.recommendationSqftRange7(list1.get(i));
                            for (StorageUnit s : collection) {
                                finalList.add(s);
                            }
                        } else if (list.get(j) > 2000 && list.get(j) <= 4000) {
                            System.out.println("9th range 2000 to 4000");
                            collection = hasARepository.recommendationSqftRange7(list1.get(i));
                            for (StorageUnit s : collection) {
                                finalList.add(s);
                            }
                        } else if (list.get(j) > 4000 && list.get(j) <= 8000) {
                            System.out.println("10th range 4000 to 8000");
                            collection = hasARepository.recommendationSqftRange7(list1.get(i));
                            for (StorageUnit s : collection) {
                                finalList.add(s);
                            }
                        }
                    }
                }
            }
            System.out.println(finalList);
            return finalList;
    }
}
