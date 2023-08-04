package Utils;


public class Type{
    public String type;
    public int dim;
    public boolean is_Class;
    public Type (String type){
        this.type = type;
        this.is_Class = false;
        if(!type.equals("void") && !type.equals("int") && !type.equals("bool") && !type.equals("string")){
            this.is_Class = true;
        }
    }
    public Type (String type,int dim){
        this(type);
        this.dim = dim;
    }
    @Override
    public boolean equals(Object obj){
        if(obj == null)return false;
        if(obj == this)return true;
        if(!(obj instanceof Type))return false;
        Type t = (Type)obj;
        if(this.type.equals(t.type) && this.dim == t.dim)return true;
        else return false;
    }
    public boolean is_array(){
        return dim>0;
    }
}
