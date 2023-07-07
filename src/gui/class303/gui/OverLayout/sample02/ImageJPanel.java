package gui.class303.gui.OverLayout.sample02;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ImageJPanel extends JPanel {
	private Image image ;

	public ImageJPanel() { }

	public ImageJPanel( String imagePath ) {
		this( new ImageIcon( imagePath ).getImage()) ;
	}

	public ImageJPanel( Image image ) {
		this( image, null ) ;

	}

	public ImageJPanel( Image image, LayoutManager manager ) {
		this.image = image ;
		Dimension dim = 
				new Dimension(image.getWidth(null), image.getHeight( null ) ) ;
		setPreferredSize(dim);
		setMaximumSize(dim);
		setMinimumSize(dim);
		setLayout( manager );
		setOpaque( image != null );
	}

	@Override
	public void  paintComponent(Graphics g) {
		if( ! super.isOpaque()  ) return ;
		Dimension dim = getSize();
		g.drawImage(image, 0, 0,  dim.width, dim.height,  null) ;
	}
}



