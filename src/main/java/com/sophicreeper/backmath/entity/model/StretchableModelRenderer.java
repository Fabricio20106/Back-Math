package com.sophicreeper.backmath.entity.model;

import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class StretchableModelRenderer {
    @OnlyIn(Dist.CLIENT)
    public static class ModelBox {
        public final TexturedQuad[] quads;
        public final float x1;
        public final float y1;
        public final float z1;
        public final float x2;
        public final float y2;
        public final float z2;

        public ModelBox(int textureWidth, int textureHeight, int u, int v, float x, float y, float z, int distanceX, int distanceY, int distanceZ, float delta, boolean mirror) {
            this.x1 = x;
            this.y1 = y;
            this.z1 = z;
            this.x2 = x + (float) distanceX;
            this.y2 = y + (float) distanceY;
            this.z2 = z + (float) distanceZ;
            this.quads = new TexturedQuad[5];
            float f = x + (float) distanceX;
            float f1 = y + (float) distanceY;
            float f2 = z + (float) distanceZ;
            x -= delta;
            y -= delta;
            z -= delta;
            f += delta;
            f1 += delta;
            f2 += delta;
            if (mirror) {
                float f3 = f;
                f = x;
                x = f3;
            }

            PositionTextureVertex vertex1 = new PositionTextureVertex(x, y, z, 0, 0);
            PositionTextureVertex vertex2 = new PositionTextureVertex(f, y, z, 0, 8);
            PositionTextureVertex vertex3 = new PositionTextureVertex(f, f1, z, 8, 8);
            PositionTextureVertex vertex4 = new PositionTextureVertex(x, f1, z, 8, 0);
            PositionTextureVertex vertex5 = new PositionTextureVertex(x, y, f2, 0, 0);
            PositionTextureVertex vertex6 = new PositionTextureVertex(f, y, f2, 0, 8);
            PositionTextureVertex vertex7 = new PositionTextureVertex(f, f1, f2, 8, 8);
            PositionTextureVertex vertex8 = new PositionTextureVertex(x, f1, f2, 8, 0);
            this.quads[0] = new TexturedQuad(new PositionTextureVertex[] {vertex6, vertex2, vertex3, vertex7}, (float) (u + distanceZ + distanceX), (float)(v + distanceZ), (float)(u + distanceZ + distanceX + distanceZ), (float)(v + distanceZ + distanceY), (float)textureWidth, (float)textureHeight, mirror, Direction.EAST);
            this.quads[1] = new TexturedQuad(new PositionTextureVertex[] {vertex1, vertex5, vertex8, vertex4}, (float) u, (float)(v + distanceZ), (float)(u + distanceZ), (float)(v + distanceZ + distanceY), (float)textureWidth, (float)textureHeight, mirror, Direction.WEST);
            this.quads[2] = new TexturedQuad(new PositionTextureVertex[] {vertex6, vertex5, vertex1, vertex2}, (float)(u + distanceZ), (float)v, (float)(u + distanceZ + distanceX), (float)(v + distanceZ), (float)textureWidth, (float)textureHeight, mirror, Direction.DOWN);
            this.quads[3] = new TexturedQuad(new PositionTextureVertex[] {vertex3, vertex4, vertex8, vertex7}, (float)(u + distanceZ), (float)(v + distanceZ + 4), (float)(u + distanceZ + distanceX), (float)(v + 1 + distanceZ + distanceY), (float)textureWidth, (float)(textureHeight - 1), mirror, Direction.UP);
            this.quads[4] = new TexturedQuad(new PositionTextureVertex[] {vertex2, vertex1, vertex4, vertex3}, (float)(u + distanceZ), (float)(v + distanceZ), (float)(u + distanceZ + distanceX), (float)(v + distanceZ + distanceY), (float)textureWidth, (float)textureHeight, mirror, Direction.NORTH);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class PositionTextureVertex {
        public final Vector3f pos;
        public final float posX;
        public final float posY;

        public PositionTextureVertex(float x, float y, float z, float posX, float posY) {
            this(new Vector3f(x, y, z), posX, posY);
        }

        public PositionTextureVertex setTexturePosition(float posX, float posY) {
            return new PositionTextureVertex(this.pos, posX, posY);
        }

        public PositionTextureVertex(Vector3f pos, float posX, float posY) {
            this.pos = pos;
            this.posX = posX;
            this.posY = posY;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class TexturedQuad {
        public final PositionTextureVertex[] positions;
        public final Vector3f normal;

        public TexturedQuad(PositionTextureVertex[] positions, float u1, float v1, float u2, float v2, float textureWidth, float textureHeight, boolean mirror, Direction direction) {
            this.positions = positions;
            float width = 0 / textureWidth;
            float height = 0 / textureHeight;
            positions[0] = positions[0].setTexturePosition(u2 / textureWidth - width, v1 / textureHeight + height);
            positions[1] = positions[1].setTexturePosition(u1 / textureWidth + width, v1 / textureHeight + height);
            positions[2] = positions[2].setTexturePosition(u1 / textureWidth + width, v2 / textureHeight - height);
            positions[3] = positions[3].setTexturePosition(u2 / textureWidth - width, v2 / textureHeight - height);

            if (mirror) {
                int i = positions.length;

                for (int j = 0; j < i / 2; ++j) {
                    PositionTextureVertex modelrenderer$positiontexturevertex = positions[j];
                    positions[j] = positions[i - 1 - j];
                    positions[i - 1 - j] = modelrenderer$positiontexturevertex;
                }
            }

            this.normal = direction.step();
            if (mirror) this.normal.mul(-1, 1, 1);
        }
    }
}
