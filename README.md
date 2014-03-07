Sierpinski Triangle
==========

Author: Tim Solum
Website: solhub.me

I recently found out about L-systems and I have always had a fasciantion with Sierpinski triangles. Pair these two together and this is what happens. This is, simply put, a java class that is used to create Sierpinski triangles using an L-system. Starting at 8 generations the triangle begins to look really good. Simply have a Graphics2D object and pass it into an object of this class's draw(Graphics2D) method and enjoy the pretty Sierpinski triangle that follows. You will likely need to use the Graphics2D scale and translate methods to fully see the Sierpinski triangle. 

You can also save the Sierpinski triangle to a png image using the saveToPng(filename) method. Keep in mind I did not optimize this method in any way so there is a good chance it could take awhile to make the image depending on how many generations you used. 
