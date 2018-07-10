type DataFatturaType: string

type QuantitaType: double

type GiorniTerminePagamentoType: int

type CABType: string

type ABIType: string

type CAPType: string

type NumeroLineaType: int

type NumeroColliType: int

type RiferimentoFaseType: int

type RateType: double

type Amount2DecimalType: double

type Amount8DecimalType: double

type PesoType: double

type EmailType: string

type TelFaxType: string

type BolloVirtualeType: string

type NumeroCivicoType: string

type TipoResaType: string

type DivisaType: string

type NazioneType: string

type ProvinciaType: string

type String1000LatinType: string

type String200LatinType: string

type String100LatinType: string

type String80LatinType: string

type String60LatinType: string

type String100Type: string

type String80Type: string

type String60Type: string

type String35Type: string

type String20Type: string

type String15Type: string

type String10Type: string

type TitoloType: string

type TipoCessionePrestazioneType: string

type StatoLiquidazioneType: string

type SocioUnicoType: string

type CodEORIType: string

type CodiceFiscalePFType: string

type CodiceFiscaleType: string

type NaturaType: string

type EsigibilitaIVAType: string

type RitenutaType: string

type BICType: string

type IBANType: string

type ModalitaPagamentoType: string

type CondizioniPagamentoType: string

type RegimeFiscaleType: string

type SoggettoEmittenteType: string

type RiferimentoNumeroLineaType: int

type TipoRitenutaType: string

type TipoDocumentoType: string

type TipoCassaType: string

type Art73Type: string

type TipoScontoMaggiorazioneType: string

type CausalePagamentoType: string

type FormatoTrasmissioneType: string

type CodiceType: string

type CodiceDestinatarioType: string

type DatiRiepilogoType:void{

.AliquotaIVA[1,1] : RateType

.Natura[0,1] : NaturaType

.SpeseAccessorie[0,1] : Amount2DecimalType

.Arrotondamento[0,1] : Amount8DecimalType

.ImponibileImporto[1,1] : Amount2DecimalType

.Imposta[1,1] : Amount2DecimalType

.EsigibilitaIVA[0,1] : EsigibilitaIVAType

.RiferimentoNormativo[0,1] : String100LatinType

}

type AltriDatiGestionaliType:void{

.TipoDato[1,1] : String10Type

.RiferimentoTesto[0,1] : String60LatinType

.RiferimentoNumero[0,1] : Amount8DecimalType

.RiferimentoData[0,1] : string

}

type CodiceArticoloType:void{

.CodiceTipo[1,1] : String35Type

.CodiceValore[1,1] : String35Type

}

type DettaglioLineeType:void{

.NumeroLinea[1,1] : NumeroLineaType

.TipoCessionePrestazione[0,1] : TipoCessionePrestazioneType

.CodiceArticolo[0,*] : CodiceArticoloType

.Descrizione[1,1] : String1000LatinType

.Quantita[0,1] : QuantitaType

.UnitaMisura[0,1] : String10Type

.DataInizioPeriodo[0,1] : string

.DataFinePeriodo[0,1] : string

.PrezzoUnitario[1,1] : Amount8DecimalType

.ScontoMaggiorazione[0,*] : ScontoMaggiorazioneType

.PrezzoTotale[1,1] : Amount8DecimalType

.AliquotaIVA[1,1] : RateType

.Ritenuta[0,1] : RitenutaType

.Natura[0,1] : NaturaType

.RiferimentoAmministrazione[0,1] : String20Type

.AltriDatiGestionali[0,*] : AltriDatiGestionaliType

}

type AllegatiType:void{

.NomeAttachment[1,1] : String60LatinType

.AlgoritmoCompressione[0,1] : String10Type

.FormatoAttachment[0,1] : String10Type

.DescrizioneAttachment[0,1] : String100LatinType

.Attachment[1,1] : raw

}

type DatiAnagraficiTerzoIntermediarioType:void{

.IdFiscaleIVA[0,1] : IdFiscaleType

.CodiceFiscale[0,1] : CodiceFiscaleType

.Anagrafica[1,1] : AnagraficaType

}

type TerzoIntermediarioSoggettoEmittenteType:void{

.DatiAnagrafici[1,1] : DatiAnagraficiTerzoIntermediarioType

}

type DettaglioPagamentoType:void{

.Beneficiario[0,1] : String200LatinType

.ModalitaPagamento[1,1] : ModalitaPagamentoType

.DataRiferimentoTerminiPagamento[0,1] : string

.GiorniTerminiPagamento[0,1] : GiorniTerminePagamentoType

.DataScadenzaPagamento[0,1] : string

.ImportoPagamento[1,1] : Amount2DecimalType

.CodUfficioPostale[0,1] : String20Type

.CognomeQuietanzante[0,1] : String60LatinType

.NomeQuietanzante[0,1] : String60LatinType

.CFQuietanzante[0,1] : CodiceFiscalePFType

.TitoloQuietanzante[0,1] : TitoloType

.IstitutoFinanziario[0,1] : String80LatinType

.IBAN[0,1] : IBANType

.ABI[0,1] : ABIType

.CAB[0,1] : CABType

.BIC[0,1] : BICType

.ScontoPagamentoAnticipato[0,1] : Amount2DecimalType

.DataLimitePagamentoAnticipato[0,1] : string

.PenalitaPagamentiRitardati[0,1] : Amount2DecimalType

.DataDecorrenzaPenale[0,1] : string

.CodicePagamento[0,1] : String60Type

}

type DatiPagamentoType:void{

.CondizioniPagamento[1,1] : CondizioniPagamentoType

.DettaglioPagamento[1,*] : DettaglioPagamentoType

}

type DatiVeicoliType:void{

.Data[1,1] : string

.TotalePercorso[1,1] : String15Type

}

type DatiBeniServiziType:void{

.DettaglioLinee[1,*] : DettaglioLineeType

.DatiRiepilogo[1,*] : DatiRiepilogoType

}

type DatiAnagraficiCessionarioType:void{

.IdFiscaleIVA[0,1] : IdFiscaleType

.CodiceFiscale[0,1] : CodiceFiscaleType

.Anagrafica[1,1] : AnagraficaType

}

type RappresentanteFiscaleCessionarioType:void{

.IdFiscaleIVA[1,1] : IdFiscaleType

}

type CessionarioCommittenteType:void{

.DatiAnagrafici[1,1] : DatiAnagraficiCessionarioType

.Sede[1,1] : IndirizzoType

.StabileOrganizzazione[0,1] : IndirizzoType

.RappresentanteFiscale[0,1] : RappresentanteFiscaleCessionarioType

}

type DatiAnagraficiRappresentanteType:void{

.IdFiscaleIVA[1,1] : IdFiscaleType

.CodiceFiscale[0,1] : CodiceFiscaleType

.Anagrafica[1,1] : AnagraficaType

}

type RappresentanteFiscaleType:void{

.DatiAnagrafici[1,1] : DatiAnagraficiRappresentanteType

}

type ContattiType:void{

.Telefono[0,1] : TelFaxType

.Fax[0,1] : TelFaxType

.Email[0,1] : EmailType

}

type IscrizioneREAType:void{

.Ufficio[1,1] : ProvinciaType

.NumeroREA[1,1] : String20Type

.CapitaleSociale[0,1] : Amount2DecimalType

.SocioUnico[0,1] : SocioUnicoType

.StatoLiquidazione[1,1] : StatoLiquidazioneType

}

type DatiAnagraficiVettoreType:void{

.IdFiscaleIVA[1,1] : IdFiscaleType

.CodiceFiscale[0,1] : CodiceFiscaleType

.Anagrafica[1,1] : AnagraficaType

.NumeroLicenzaGuida[0,1] : String20Type

}

type AnagraficaType:void{

.Titolo[0,1] : TitoloType

.CodEORI[0,1] : CodEORIType

}

type DatiAnagraficiCedenteType:void{

.IdFiscaleIVA[1,1] : IdFiscaleType

.CodiceFiscale[0,1] : CodiceFiscaleType

.Anagrafica[1,1] : AnagraficaType

.AlboProfessionale[0,1] : String60LatinType

.ProvinciaAlbo[0,1] : ProvinciaType

.NumeroIscrizioneAlbo[0,1] : String60Type

.DataIscrizioneAlbo[0,1] : string

.RegimeFiscale[1,1] : RegimeFiscaleType

}

type CedentePrestatoreType:void{

.DatiAnagrafici[1,1] : DatiAnagraficiCedenteType

.Sede[1,1] : IndirizzoType

.StabileOrganizzazione[0,1] : IndirizzoType

.IscrizioneREA[0,1] : IscrizioneREAType

.Contatti[0,1] : ContattiType

.RiferimentoAmministrazione[0,1] : String20Type

}

type FatturaPrincipaleType:void{

.NumeroFatturaPrincipale[1,1] : String20Type

.DataFatturaPrincipale[1,1] : string

}

type IndirizzoType:void{

.Indirizzo[1,1] : String60LatinType

.NumeroCivico[0,1] : NumeroCivicoType

.CAP[1,1] : CAPType

.Comune[1,1] : String60LatinType

.Provincia[0,1] : ProvinciaType

.Nazione[1,1] : NazioneType

}

type DatiTrasportoType:void{

.DatiAnagraficiVettore[0,1] : DatiAnagraficiVettoreType

.MezzoTrasporto[0,1] : String80LatinType

.CausaleTrasporto[0,1] : String100LatinType

.NumeroColli[0,1] : NumeroColliType

.Descrizione[0,1] : String100LatinType

.UnitaMisuraPeso[0,1] : String10Type

.PesoLordo[0,1] : PesoType

.PesoNetto[0,1] : PesoType

.DataOraRitiro[0,1] : string

.DataInizioTrasporto[0,1] : string

.TipoResa[0,1] : TipoResaType

.IndirizzoResa[0,1] : IndirizzoType

.DataOraConsegna[0,1] : string

}

type DatiDDTType:void{

.NumeroDDT[1,1] : String20Type

.DataDDT[1,1] : string

.RiferimentoNumeroLinea[0,*] : RiferimentoNumeroLineaType

}

type DatiDocumentiCorrelatiType:void{

.RiferimentoNumeroLinea[0,*] : RiferimentoNumeroLineaType

.IdDocumento[1,1] : String20Type

.Data[0,1] : string

.NumItem[0,1] : String20Type

.CodiceCommessaConvenzione[0,1] : String100LatinType

.CodiceCUP[0,1] : String15Type

.CodiceCIG[0,1] : String15Type

}

type DatiSALType:void{

.RiferimentoFase[1,1] : RiferimentoFaseType

}

type ScontoMaggiorazioneType:void{

.Tipo[1,1] : TipoScontoMaggiorazioneType

.Percentuale[0,1] : RateType

.Importo[0,1] : Amount2DecimalType

}

type DatiCassaPrevidenzialeType:void{

.TipoCassa[1,1] : TipoCassaType

.AlCassa[1,1] : RateType

.ImportoContributoCassa[1,1] : Amount2DecimalType

.ImponibileCassa[0,1] : Amount2DecimalType

.AliquotaIVA[1,1] : RateType

.Ritenuta[0,1] : RitenutaType

.Natura[0,1] : NaturaType

.RiferimentoAmministrazione[0,1] : String20Type

}

type DatiBolloType:void{

.BolloVirtuale[1,1] : BolloVirtualeType

.ImportoBollo[1,1] : Amount2DecimalType

}

type DatiRitenutaType:void{

.TipoRitenuta[1,1] : TipoRitenutaType

.ImportoRitenuta[1,1] : Amount2DecimalType

.AliquotaRitenuta[1,1] : RateType

.CausalePagamento[1,1] : CausalePagamentoType

}

type DatiGeneraliDocumentoType:void{

.TipoDocumento[1,1] : TipoDocumentoType

.Divisa[1,1] : DivisaType

.Data[1,1] : DataFatturaType

.Numero[1,1] : String20Type

.DatiRitenuta[0,1] : DatiRitenutaType

.DatiBollo[0,1] : DatiBolloType

.DatiCassaPrevidenziale[0,*] : DatiCassaPrevidenzialeType

.ScontoMaggiorazione[0,*] : ScontoMaggiorazioneType

.ImportoTotaleDocumento[0,1] : Amount2DecimalType

.Arrotondamento[0,1] : Amount2DecimalType

.Causale[0,*] : String200LatinType

.Art73[0,1] : Art73Type

}

type DatiGeneraliType:void{

.DatiGeneraliDocumento[1,1] : DatiGeneraliDocumentoType

.DatiOrdineAcquisto[0,*] : DatiDocumentiCorrelatiType

.DatiContratto[0,*] : DatiDocumentiCorrelatiType

.DatiConvenzione[0,*] : DatiDocumentiCorrelatiType

.DatiRicezione[0,*] : DatiDocumentiCorrelatiType

.DatiFattureCollegate[0,*] : DatiDocumentiCorrelatiType

.DatiSAL[0,*] : DatiSALType

.DatiDDT[0,*] : DatiDDTType

.DatiTrasporto[0,1] : DatiTrasportoType

.FatturaPrincipale[0,1] : FatturaPrincipaleType

}

type ContattiTrasmittenteType:void{

.Telefono[0,1] : TelFaxType

.Email[0,1] : EmailType

}

type IdFiscaleType:void{

.IdPaese[1,1] : NazioneType

.IdCodice[1,1] : CodiceType

}

type DatiTrasmissioneType:void{

.IdTrasmittente[1,1] : IdFiscaleType

.ProgressivoInvio[1,1] : String10Type

.FormatoTrasmissione[1,1] : FormatoTrasmissioneType

.CodiceDestinatario[1,1] : CodiceDestinatarioType

.ContattiTrasmittente[0,1] : ContattiTrasmittenteType

.PECDestinatario[0,1] : EmailType

}

type FatturaElettronicaBodyType:void{

.DatiGenerali[1,1] : DatiGeneraliType

.DatiBeniServizi[1,1] : DatiBeniServiziType

.DatiVeicoli[0,1] : DatiVeicoliType

.DatiPagamento[0,*] : DatiPagamentoType

.Allegati[0,*] : AllegatiType

}

type FatturaElettronicaHeaderType:void{

.DatiTrasmissione[1,1] : DatiTrasmissioneType

.CedentePrestatore[1,1] : CedentePrestatoreType

.RappresentanteFiscale[0,1] : RappresentanteFiscaleType

.CessionarioCommittente[1,1] : CessionarioCommittenteType

.TerzoIntermediarioOSoggettoEmittente[0,1] : TerzoIntermediarioSoggettoEmittenteType

.SoggettoEmittente[0,1] : SoggettoEmittenteType

}

type FatturaElettronicaType:void{

.FatturaElettronicaHeader[1,1] : FatturaElettronicaHeaderType

.FatturaElettronicaBody[1,*] : FatturaElettronicaBodyType

}
