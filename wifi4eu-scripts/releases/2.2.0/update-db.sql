CREATE TABLE [dbo].[budgetary_commitment](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[global_commitment] [int] NOT NULL,
  [municipality] [int] NOT NULL,
	[position] [int] NOT NULL,
	[ammount] [int] NOT NULL,
	[abac_bc_key] [varchar](255) NULL,
	[abac_lc_key] [varchar](255) NULL
) ON [PRIMARY];

ALTER TABLE [dbo].[budgetary_commitment] WITH CHECK ADD CONSTRAINT [fk_budgetary_commitment_with_global_commitment] FOREIGN KEY([global_commitment])
REFERENCES [dbo].[global_commitment] ([id]);

ALTER TABLE [dbo].[budgetary_commitment] WITH CHECK ADD CONSTRAINT [fk_budgetary_commitment_with_municipalities] FOREIGN KEY([municipality])
REFERENCES [dbo].[municipalities] ([id]);