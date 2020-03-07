package Uml;

public class Factura {

 private Double iva;

  private Double propina;

   private Double precio;

    private String concepto;

    private int cantidad;

    private Double total;
    public int numventas;
    

    public int getNumventas(){
        return numventas;
    }
    public void setNumventas(){
        this.numventas= numventas;
    }

    public Double getIva() {
        return iva;
        
    }
    public void setIva(Double iva) {
        this.iva = iva;
        
    }

    
    public Double getPropina() {
        return propina;
    }
    public void setPropina(Double propina) {
        this.propina = propina;
    }

    
    public Double getPrecio() {
        return precio;
    }
    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
     public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    
    public String getConcepto() {
        return concepto;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getCantidad() {
        return cantidad;
    }

    public Double getTotal() {
        return total;
    }
    public void setTotal(Double total) {
        this.total = total;
    }

    

    
    

   

    

    
}
