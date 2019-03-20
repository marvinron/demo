package com.example.demo.comparable;

/**
 * @author houlei
 * @DESC:实体类
 * @create 2019-01-15 9:30
 */
public class Dept implements Comparable<Dept> {
    private String id;
    private String name;
    private long number;

    public Dept(String id, String name, long number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    @Override
    public int compareTo(Dept o) {
        int i=0;
        //如果id不相等 比较id的大小
        i= this.id.compareTo(o.id);
        if(i !=0){
            return i;
            //如果id相等  比较name
        }else {
            i= this.name.compareTo(o.name);
            if(i !=0){
                return i;
            }else{
                if(this.number>o.number){

                    return 1;
                }else if(this.number<o.number){

                    return -1;
                }else {
                    return 0;
                }

            }

        }

    }
}
