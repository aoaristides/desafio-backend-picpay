package br.com.makersweb.picpay.application;

/**
 * @author aoaristides
 * @param <IN>
 * @param <OUT>
 */
public abstract class UseCase<IN, OUT> {

    public abstract OUT execute(IN anIn);

}
