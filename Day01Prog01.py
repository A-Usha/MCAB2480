def calculateCylSurfacearea():

   pi=3.14159
   radius=float(input("Enter radius:"))
   height=int(input("Enter height:"))
   base_area=pi*radius*2
   volume=base_area*height
   surface_area=2*base_area+2*pi*radius*height
   print("volume is",volume,",surface area is ",surface_area)
   ##res="Volume is" ,volume,"Surface area is",surface_area
   ##return res


##radius=float(input("Enter radius:"))
##height=int(input("Enter height:"))
calculateCylSurfacearea()

