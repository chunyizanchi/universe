package com.cyzc.designpattern.builderPattern;

import org.apache.commons.lang3.StringUtils;

/**
 * <描述>
 *
 * @author Cyzc
 * @since 2021-08-26
 */
public class ResourcePoolConfig implements Cloneable {

    private String name;

    private int maxTotal;

    private int maxIdle;

    private int minIdle;


    private ResourcePoolConfig(Builder builder) {
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    @Override
    public ResourcePoolConfig clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (ResourcePoolConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public static class Builder {

        private static final int DEFAULT_MAX_TOTAL = 100;
        private static final int DEFAULT_MAX_IDLE = 100;
        private static final int DEFAULT_MIN_IDLE = 100;

        private String name;

        private int maxTotal = DEFAULT_MAX_TOTAL;

        private int maxIdle = DEFAULT_MAX_IDLE;

        private int minIdle = DEFAULT_MIN_IDLE;


        public ResourcePoolConfig build() {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            if (maxIdle > maxTotal) {
                throw new IllegalArgumentException("...");
            }
            if (minIdle > maxTotal || minIdle > maxIdle) {
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name) {
            if (StringUtils.isBlank(name)) {
                throw new IllegalArgumentException("...");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal) {
            if (maxTotal <= 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle) {
            if (maxIdle < 0) {
                throw new IllegalArgumentException("...");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle) {
            if (minIdle < 0) {
                throw new IllegalArgumentException("...");
            }
            this.minIdle = minIdle;
            return this;
        }

    }

    @Override
    public String toString() {
        return "ResourcePoolConfig{" +
                "name='" + name + '\'' +
                ", maxTotal=" + maxTotal +
                ", maxIdle=" + maxIdle +
                ", minIdle=" + minIdle +
                '}';
    }
}

class test {
    public static void main(String[] args) {
        ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                .setName("dbconnectionpool")
                .setMaxTotal(1000)
                .setMaxIdle(10)
                .setMinIdle(9).build();
        System.out.println(config.toString());
    }

}