/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ondra
 */

public class NewJFrame extends JFrame {
    private BufferedImage currentImage = null; // Proměnná pro aktuální obrázek
    private BufferedImage previousImage = null; // Proměnná pro původní obrázek

    private int[][] matrix = {
            {
                1, 1, 1
            },
            {
                1, 1, 1
            },
            {
                1, 1, 1
            }
    };
    private boolean normalize = true;

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setImageButton = new JButton();
        editMatrixButton = new JButton();
        applyMatrixButton = new JButton();
        jScrollPane1 = new JScrollPane();
        generateImageButton = new JButton();
        restoreOriginalButton = new JButton();
        originalRadioButton = new JRadioButton();
        modifiedRadioButton = new JRadioButton();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jMenuBar1 = new JMenuBar();
        fileMenu = new JMenu();
        loadImageMenuItem = new JMenuItem();
        saveImageMenuItem = new JMenuItem();
        filtersMenu = new JMenu();
        negativeFilterMenuItem = new JMenuItem();
        pixelizerFilterMenuItem = new JMenuItem();
        identityFilterMenuItem = new JMenuItem();
        sharpeningFilterMenuItem = new JMenuItem();
        blurFilterMenuItem = new JMenuItem();
        //bwFilterMenuItem = new JMenuItem();
        //vinetteFilterMenuItem = new JMenuItem();
        //colorizerFilterMenuItem = new JMenuItem();
        aboutMenu = new JMenu();
        exitMenu = new JMenu();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setImageButton.setText("Select Image file");
        setImageButton.setMaximumSize(new Dimension(120, 25));
        setImageButton.setMinimumSize(new Dimension(120, 25));
        setImageButton.setPreferredSize(new Dimension(160, 25));
        setImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionLoad(evt);
            }
        });

        editMatrixButton.setText("Edit matrix");
        editMatrixButton.setMaximumSize(new Dimension(120, 25));
        editMatrixButton.setMinimumSize(new Dimension(120, 25));
        editMatrixButton.setPreferredSize(new Dimension(160, 25));

        applyMatrixButton.setText("Apply matrix filter");
        applyMatrixButton.setPreferredSize(new Dimension(160, 25));
        applyMatrixButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionApplyMatrixFilter(evt);
            }
        });

        generateImageButton.setText("Generate Image");
        generateImageButton.setPreferredSize(new Dimension(160, 40));
        generateImageButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionGenerate(evt);
            }
        });

        restoreOriginalButton.setText("Restore Original Image");
        restoreOriginalButton.setPreferredSize(new Dimension(160, 40));
        restoreOriginalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionRestore();
            }
        });
        restoreOriginalButton.setEnabled(false);

        originalRadioButton.setEnabled(false);
        modifiedRadioButton.setEnabled(false);
        originalRadioButton.setText("Original Image");
        modifiedRadioButton.setText("Modified Image");

        setPreferredSize(new Dimension(1000, 800)); //Základní velikost okna

        // Group the buttons
        ButtonGroup group = new ButtonGroup();
        group.add(originalRadioButton);
        group.add(modifiedRadioButton);

        originalRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDisplayedImage(previousImage);
            }
        });

        modifiedRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateDisplayedImage(currentImage);
            }
        });

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        // The "file" menu group
        fileMenu.setText("   File");
        fileMenu.setPreferredSize(new Dimension(50, 11));
        fileMenu.setVerticalAlignment(SwingConstants.TOP);

        loadImageMenuItem.setText("Load Image");
        loadImageMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionLoad(evt);
            }
        });
        fileMenu.add(loadImageMenuItem);

        saveImageMenuItem.setText("Save Image");
        saveImageMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                actionSave(evt);
            }
        });
        fileMenu.add(saveImageMenuItem);

        jMenuBar1.add(fileMenu);

        // The "filters" menu group
        filtersMenu.setText("Filters");
        filtersMenu.setPreferredSize(new Dimension(50, 11));
        filtersMenu.setVerticalAlignment(SwingConstants.TOP);

        negativeFilterMenuItem.setText("Negative");
        filtersMenu.add(negativeFilterMenuItem);
        negativeFilterMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                filterNegative();
            }
        });

        pixelizerFilterMenuItem.setText("Pixelizer");
        filtersMenu.add(pixelizerFilterMenuItem);
        pixelizerFilterMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                filterPixelizer();
            }
        });

        identityFilterMenuItem.setText("Identity");
        filtersMenu.add(identityFilterMenuItem);
        identityFilterMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                filterIdentity();
            }
        });

        sharpeningFilterMenuItem.setText("RGBizer");
        filtersMenu.add(sharpeningFilterMenuItem);
        sharpeningFilterMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                filterRGBizer();
            }
        });

        blurFilterMenuItem.setText("Blur");
        filtersMenu.add(blurFilterMenuItem);
        blurFilterMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                filterBlur();
            }
        });

        /*
        bwFilterMenuItem.setText("BW filter");
        filtersMenu.add(bwFilterMenuItem);

        vinetteFilterMenuItem.setText("Vinette");
        filtersMenu.add(vinetteFilterMenuItem);

        colorizerFilterMenuItem.setText("Colorizer");
        filtersMenu.add(colorizerFilterMenuItem);
         */

        jMenuBar1.add(filtersMenu);

        aboutMenu.setText("About");
        aboutMenu.setPreferredSize(new Dimension(50, 11));
        aboutMenu.setVerticalAlignment(SwingConstants.TOP);
        jMenuBar1.add(aboutMenu);

        aboutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionAbout();
            }
        });

        exitMenu.setText("Exit");
        exitMenu.setMaximumSize(new Dimension(50, 546444));
        exitMenu.setPreferredSize(new Dimension(50, 20));
        exitMenu.setVerticalAlignment(SwingConstants.TOP);
        exitMenu.setVerticalTextPosition(SwingConstants.TOP);
        jMenuBar1.add(exitMenu);

        exitMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actionExit();
            }
        });

        jPanel3.setLayout(new BorderLayout());
        jPanel3.add(imageLabel, BorderLayout.CENTER);

        setJMenuBar(jMenuBar1);

        logTextArea = new JTextArea();
        logTextArea.setEditable(false);
        logTextArea.setLineWrap(true);
        logTextArea.setWrapStyleWord(true);

        jScrollPane1.setViewportView(logTextArea);

        jPanel2.setLayout(new BorderLayout());
        jPanel2.add(matrixImageLabel, BorderLayout.CENTER);
        matrixImageLabel.setPreferredSize(new Dimension(120, 120));

        int[][] matrix = {
                {3, 2, 1},
                {4, 0, -1},
                {-4, -3, -2}
        };
        createMatrixPreview(matrix);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(editMatrixButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(setImageButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(applyMatrixButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(generateImageButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(restoreOriginalButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(originalRadioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(modifiedRadioButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(setImageButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(editMatrixButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(applyMatrixButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(generateImageButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(restoreOriginalButton, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(originalRadioButton)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modifiedRadioButton))
                    .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void actionRestore() {
        printIntoLog("Restored previous image.");
        currentImage = previousImage;
        updateDisplayedImage(currentImage);
        restoreOriginalButton.setEnabled(false);
    }

    private void filterRGBizer() {
        if (currentImage == null) {
            JOptionPane.showMessageDialog(this, "There is no image loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        printIntoLog("Applied RGBizer filter");
        previousImage = currentImage;   // Save the current image as the previous image

        // Apply blur to current picture
        int[][] RGBizerMatrix = {
                {-1, -1, -1},
                {-1, 17, -1},
                {-1, -1, -1},
        };
        applyMatrixFilter(RGBizerMatrix, true);
        updateDisplayedImage(currentImage);
        modifiedRadioButton.setEnabled(true);
        modifiedRadioButton.setSelected(true);
        restoreOriginalButton.setEnabled(true);
    }

    private void filterBlur() {
        if (currentImage == null) {
            JOptionPane.showMessageDialog(this, "There is no image loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        printIntoLog("Applied blur filter");
        previousImage = currentImage;   // Save the current image as the previous image

        int[][] blurMatrix = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        };

        applyMatrixFilter(blurMatrix, true);
        updateDisplayedImage(currentImage);
        modifiedRadioButton.setEnabled(true);
        modifiedRadioButton.setSelected(true);
        restoreOriginalButton.setEnabled(true);
    }


    private void actionExit() {
        System.exit(0);
    }

    private void actionAbout() {
        JOptionPane.showMessageDialog(this, "Program Vytvořili:\n- Matematik: Artur Balák\n- GUI designér: Ondřej Tichý\n- Generální zprovozňovatel: Alex Brožík\n- Nějak zařídil aby to vůbec jelo: Herbert Géč\n\nSpeciální poděkování patří Petru Pavlovi.", "Credits", JOptionPane.INFORMATION_MESSAGE);
    }

    private void actionApplyMatrixFilter(ActionEvent evt) {
        if (currentImage == null) {
            JOptionPane.showMessageDialog(this, "There is no image loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        printIntoLog("Applied matrix filter");
        previousImage = currentImage;   // Save the current image as the previous image

        applyMatrixFilter(this.matrix, this.normalize);
        updateDisplayedImage(currentImage);
        modifiedRadioButton.setEnabled(true);
        modifiedRadioButton.setSelected(true);
        restoreOriginalButton.setEnabled(true);
    }

    private void applyMatrixFilter(int[][] matrix, boolean normalize) {
        if (currentImage == null) {
            JOptionPane.showMessageDialog(this, "There is no image loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Width and height
        int currentWidth = currentImage.getWidth();
        int currentHeight = currentImage.getHeight();

        // Analyze the size of matrix
        int[] matrixSize = {matrix[0].length, matrix.length};

        // Calculate the center; calculate offsets to go between array indexes and relative position within the matrix
        // For even matrices, round the index down
        int leftMatrixOffset = Math.floorDiv(matrixSize[0] - 1, 2);
        int topMatrixOffset = Math.floorDiv(matrixSize[1] - 1, 2);

        // Generate a reference image that is expanded on all sides by half the matrix size using mirroring
        BufferedImage newImage = new BufferedImage(currentWidth, currentHeight, BufferedImage.TYPE_3BYTE_BGR);
        BufferedImage referenceImage = new BufferedImage(currentWidth + matrixSize[0] - 1, currentHeight + matrixSize[1] - 1, BufferedImage.TYPE_3BYTE_BGR);

        // Paint the original image into the reference image
        int[] imgData = new int[currentHeight * currentWidth];
        currentImage.getRGB(0, 0, currentWidth, currentHeight, imgData, 0, currentWidth);
        referenceImage.setRGB(leftMatrixOffset, topMatrixOffset, currentWidth, currentHeight, imgData, 0, currentWidth);


        // Mirror the top and bottom edge
        for (var mirroringX = leftMatrixOffset; mirroringX < leftMatrixOffset + currentWidth; mirroringX++) {
            // For every x coordinate, fill in the empty space at top
            for (var indexY = 0; indexY < topMatrixOffset; indexY++) {
                referenceImage.setRGB(mirroringX, topMatrixOffset - indexY - 1, referenceImage.getRGB(mirroringX, topMatrixOffset + indexY));
            }

            // For every x coordinate, fill in the empty space at the bottom
            for (var indexY = 0; indexY < matrixSize[1] - topMatrixOffset - 1; indexY++) {
                referenceImage.setRGB(mirroringX, currentHeight + topMatrixOffset + indexY, referenceImage.getRGB(mirroringX, currentHeight + topMatrixOffset - indexY - 1));
            }
        }

        // Mirror the left and right edge
        for (var mirroringY = 0; mirroringY < referenceImage.getHeight(); mirroringY++) {
            // For every y coordinate, fill in the empty space on the left
            for (var indexX = 0; indexX < leftMatrixOffset; indexX++) {
                referenceImage.setRGB(leftMatrixOffset - indexX - 1, mirroringY, referenceImage.getRGB(leftMatrixOffset + indexX, mirroringY));
            }

            // For every y coordinate, fill in the empty space on the right
            for (var indexX = 0; indexX < matrixSize[0] - leftMatrixOffset - 1; indexX++) {
                referenceImage.setRGB(currentWidth + leftMatrixOffset + indexX, mirroringY, referenceImage.getRGB(currentWidth + leftMatrixOffset - indexX - 1, mirroringY));
            }
        }

        // Check if the value should be normalised or not - do it outside the cycles to reduce amount of checks
        if (normalize) {
            // For every pixel in currentImage (new image), calculate it's color based on the reference image after applying convolution
            for (int x = 0; x < currentWidth; x++) {
                for (int y = 0; y < currentHeight; y++) {
                    // Define matrix helper
                    MatrixHelper m = new MatrixHelper();

                    // Go through the matrix area around the point, add each pixel to matrixHelper based on weight
                    for (int matrixX = 0; matrixX < matrixSize[0]; matrixX++) {
                        for (int matrixY = 0; matrixY < matrixSize[1]; matrixY++) {
                            m.addColor(referenceImage.getRGB(x + matrixX, y + matrixY), matrix[matrixY][matrixX]);
                        }
                    }

                    // Set the pixel in the final image (currentImage)
                    newImage.setRGB(x, y, m.getNormalisedValue());
                }
            }
        } else {
            // For every pixel in currentImage (new image), calculate it's color based on the reference image after applying convolution
            for (int x = 0; x < currentWidth; x++) {
                for (int y = 0; y < currentHeight; y++) {
                    // Define matrix helper
                    MatrixHelper m = new MatrixHelper();

                    // Go through the matrix area around the point, add each pixel to matrixHelper based on weight
                    for (int matrixX = 0; matrixX < matrixSize[0]; matrixX++) {
                        for (int matrixY = 0; matrixY < matrixSize[1]; matrixY++) {
                            m.addColor(referenceImage.getRGB(x + matrixX, y + matrixY), matrix[matrixY][matrixX]);
                        }
                    }

                    // Set the pixel in the final image (currentImage)
                    newImage.setRGB(x, y, m.getValue());
                }
            }
        }

        currentImage = newImage;
    }

    private void filterPixelizer() {
        if (currentImage == null) {
            JOptionPane.showMessageDialog(this, "There is no image loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        printIntoLog("Applied pixelizer filter");
        previousImage = currentImage;   // Save the current image as the previous image

        int currentWidth = currentImage.getWidth();
        int currentHeight = currentImage.getHeight();

        BufferedImage newImage = new BufferedImage(currentWidth + 4 - currentWidth % 4, currentHeight + 4 - currentHeight % 4, BufferedImage.TYPE_3BYTE_BGR);

        // Apply the filter
        for (int x = 0; x < currentWidth; x += 4) {
            for (int y = 0; y < currentHeight; y += 4) {
                // For every block of 4*4 pixels, calculate the average color and paint it into the new image
                MatrixHelper colorAVG = new MatrixHelper();

                for (int blockX = x; blockX < x + 4; blockX++) {
                    for (int blockY = y; blockY < y + 4; blockY++) {
                        try {
                            colorAVG.addColor(currentImage.getRGB(blockX, blockY));
                        } catch (Exception _) {
                        }
                    }
                }

                int colorValue = colorAVG.getNormalisedValue();

                for (int blockX = x; blockX < x + 4; blockX++) {
                    for (int blockY = y; blockY < y + 4; blockY++) {
                        newImage.setRGB(blockX, blockY, colorValue);
                    }
                }
            }
        }

        currentImage = newImage;
        updateDisplayedImage(currentImage);
        modifiedRadioButton.setEnabled(true);
        modifiedRadioButton.setSelected(true);
        restoreOriginalButton.setEnabled(true);
    }

    JTextArea logTextArea = new JTextArea();

    // Function for writing into log
    private void printIntoLog(String message) {
        // For now, just write to console
        //System.out.println(message);
        logTextArea.append(message + "\n");
        logTextArea.setCaretPosition(logTextArea.getDocument().getLength()); // Posun na konec textu
    }

    private void filterNegative() {
        if (currentImage == null) {
            JOptionPane.showMessageDialog(this, "There is no image loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        printIntoLog("Applied negative filter");
        previousImage = currentImage;   // Save the current image as the previous image

        BufferedImage newImage = new BufferedImage(currentImage.getWidth(), currentImage.getHeight(), BufferedImage.TYPE_3BYTE_BGR);

        // Apply the filter
        for (int x = 0; x < newImage.getWidth(); x++){
            for (int y = 0; y < newImage.getHeight(); y++){
                newImage.setRGB(x, y, 16777215 - currentImage.getRGB(x, y));
            }
        }
        currentImage = newImage;
        updateDisplayedImage(currentImage);
        modifiedRadioButton.setEnabled(true);
        modifiedRadioButton.setSelected(true);
        restoreOriginalButton.setEnabled(true);
    }

    private void filterIdentity() {
        if (currentImage == null) {
            JOptionPane.showMessageDialog(this, "There is no image loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        printIntoLog("Applied identity filter.");
        previousImage = currentImage;
        updateDisplayedImage(currentImage);
        modifiedRadioButton.setEnabled(true);
        modifiedRadioButton.setSelected(true);
        restoreOriginalButton.setEnabled(true);
        // The new image is the same as the last image
    }

    private void actionGenerate(ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        printIntoLog("Generating image...");
        int resolution = 300;

        BufferedImage generatedImg = new BufferedImage(3 * resolution, 2 * resolution, BufferedImage.TYPE_3BYTE_BGR);

        for (int x = -2 * resolution; x < generatedImg.getWidth() - 2 * resolution; x++){
            for (int y = -resolution; y < generatedImg.getHeight() - resolution; y++){
                float[] z = new float[]{0, 0};
                float[] C = new float[]{(float) x / resolution, (float) y / resolution};

                // (a + bi)^2 = a^2 + 2abi + b^2i^2 = (a˘2-b˘2) + 2abi
                // [a, b] * [a, b] = [a^2 - b^2, 2*a*b]
                // [a, b] * [a, b] + [c, d] =
                // [z[0]*z[0] - z[1]*z[1] + C[0], 2*z[0]*z[1] + C[1]]

                boolean isStable = true;
                for (int i = 0; i < 1000; i++) {
                    float newz0 = z[0]*z[0] - z[1]*z[1] + C[0];
                    float newz1 = 2*z[0]*z[1] + C[1];
                    z[0] = newz0;
                    z[1] = newz1;

                    if (z[0]*z[0] + z[1]*z[1] > 4) {
                        // Point is not in the set
                        isStable = false;
                        generatedImg.setRGB(x + 2 * resolution, y + resolution, (new Color(255, 255, 255).getRGB()));

                        break;
                    }
                }
                if (isStable) {
                    generatedImg.setRGB(x + 2 * resolution, y + resolution, (new Color(0, 0, 0).getRGB()));
                }
            }
        }
        printIntoLog("Generation finished.");
        previousImage = currentImage; // Uložení původního obrázku
        currentImage = generatedImg;

        originalRadioButton.setEnabled(true);
        originalRadioButton.setSelected(true);
        updateDisplayedImage(currentImage);
    }//GEN-LAST:event_jButton1ActionPerformed

    private JLabel imageLabel = new JLabel();

    private void updateDisplayedImage(BufferedImage image) {
        if (image != null) {
            ImageIcon imageIcon = new ImageIcon(image);
            imageLabel.setIcon(imageIcon);
            imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
            imageLabel.setVerticalAlignment(SwingConstants.CENTER);
        }
    }

    private void actionLoad(ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JFileChooser fileChooserLoad = new JFileChooser();
        int returnVal = fileChooserLoad.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooserLoad.getSelectedFile();
            try {
                previousImage = currentImage; // Uložení původního obrázku
                this.currentImage = ImageIO.read(file); // Načtení obrázku

                updateDisplayedImage(currentImage);

                originalRadioButton.setEnabled(true);
                originalRadioButton.setSelected(true);

                printIntoLog("Loaded image: " + file.getName()); // Protokolování
                //redrawPanel(); // Obnovení zobrazení panelu
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error while reading file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void actionSave(ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        if (currentImage == null) {
            JOptionPane.showMessageDialog(this, "There is no image loaded.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JFileChooser fileChooserSave = new JFileChooser();
        int returnVal = fileChooserSave.showSaveDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooserSave.getSelectedFile();
            String fileName = file.getAbsolutePath();
            if (!fileName.toLowerCase().endsWith(".jpg")) {
                file = new File(fileName + ".jpg"); // Přidání přípony, pokud chybí
            }
            try {
                ImageIO.write(this.currentImage, "jpeg", file); // Uložení obrázku
                printIntoLog("Saved image as: " + file.getName()); // Protokolování
                JOptionPane.showMessageDialog(this, "Image saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error while writing file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private static JLabel matrixImageLabel = new JLabel();

    public static void createMatrixPreview(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int cellSize = 40;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int value : row) {
                min = Math.min(min, value);
                max = Math.max(max, value);
            }
        }

        BufferedImage matrixImage = new BufferedImage(cols * cellSize, rows * cellSize, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = matrixImage.createGraphics();

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int value = matrix[row][col];

                if (value == 0) {
                    Color color = new Color(0, 0, 0);

                    g.setColor(color);
                    g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                }
                else if (value > 0) {
                    int normalizedValue = (int) (((double) value / max) * 255);
                    Color color = new Color(0, 0, normalizedValue);

                    g.setColor(color);
                    g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                }
                else {
                    int normalizedValue = (int) (((double) value / min) * 255);
                    Color color = new Color(normalizedValue, 0, 0);

                    g.setColor(color);
                    g.fillRect(col * cellSize, row * cellSize, cellSize, cellSize);
                }
            }
        }

        g.dispose();

        ImageIcon matrixImageIcon = new ImageIcon(matrixImage);
        matrixImageLabel.setIcon(matrixImageIcon);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton setImageButton;
    private JButton editMatrixButton;
    private JButton applyMatrixButton;
    private JButton generateImageButton;
    private JButton restoreOriginalButton;
    private JMenu fileMenu;
    private JMenu filtersMenu;
    private JMenu aboutMenu;
    private JMenu exitMenu;
    private JMenuBar jMenuBar1;
    private JMenuItem loadImageMenuItem;
    //private JMenuItem colorizerFilterMenuItem;
    private JMenuItem saveImageMenuItem;
    private JMenuItem negativeFilterMenuItem;
    private JMenuItem pixelizerFilterMenuItem;
    private JMenuItem identityFilterMenuItem;
    private JMenuItem sharpeningFilterMenuItem;
    private JMenuItem blurFilterMenuItem;
    //private JMenuItem bwFilterMenuItem;
    //private JMenuItem vinetteFilterMenuItem;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JRadioButton originalRadioButton;
    private JRadioButton modifiedRadioButton;
    private JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
